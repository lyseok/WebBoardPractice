package board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.controller.SendDataSrialize;

import java.io.IOException;

import com.google.gson.Gson;

import board.dao.BoardDaoImpl;
import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@WebServlet("/insertBoard.do")
public class InsertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqData = SendDataSrialize.chageData(request);
		
		// 역직렬화
		Gson gson = new Gson();
		BoardVO vo  = gson.fromJson(reqData, BoardVO.class);
		
		vo.setWip(request.getRemoteAddr());
		
		// service 객체 얻기
		IBoardService service = BoardServiceImpl.getInstance(BoardDaoImpl.getInstance());
		
		// service 메서드 호출
		int res = service.insertBoard(vo);
		
		// request에 저장
		request.setAttribute("result", res);
		
		// view 페이지로 이동
		request
			.getRequestDispatcher("board/result.jsp")
			.forward(request, response);
		
		
	}

}
