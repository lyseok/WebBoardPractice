package board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.controller.SendDataSrialize;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import board.dao.BoardDaoImpl;
import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@WebServlet("/updateBoard.do")
public class UpdateBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqData =  SendDataSrialize.chageData(request);
		
		// Gson 
		Gson gson = new Gson();
		
		BoardVO vo = gson.fromJson(reqData, BoardVO.class);
		
		vo.setWip(request.getRemoteAddr());
		
		//service 객체 얻기
		IBoardService service = BoardServiceImpl.getInstance(BoardDaoImpl.getInstance());
		
		int res = service.updateBoard(vo);
		
		request.setAttribute("result", res);
		
		request
			.getRequestDispatcher("board/result.jsp")
			.forward(request, response);

	}

}
