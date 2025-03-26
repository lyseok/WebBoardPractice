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
import board.vo.ReplyVO;

/**
 * Servlet implementation class InsertReply
 */
@WebServlet("/insertReply.do")
public class InsertReply extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqData = SendDataSrialize.chageData(request);
		
		Gson gson = new Gson();
		ReplyVO rvo = gson.fromJson(reqData, ReplyVO.class);
		
		IBoardService service = BoardServiceImpl.getInstance(BoardDaoImpl.getInstance());
		
		int res = service.insertReply(rvo);
		
		request.setAttribute("result", res);
		request.getRequestDispatcher("board/result.jsp").forward(request, response);
	}

}
