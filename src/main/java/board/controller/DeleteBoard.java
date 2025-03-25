package board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import board.dao.BoardDaoImpl;
import board.service.BoardServiceImpl;
import board.service.IBoardService;

/**
 * Servlet implementation class DeleteBoard
 */
@WebServlet("/deleteBoard.do")
public class DeleteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송 데이터 num 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		
		IBoardService service = BoardServiceImpl.getInstance(BoardDaoImpl.getInstance());
		
		int res = service.deleteBoard(num);
		
		request.setAttribute("result", res);
		
		// view 페이지로 이동
		request
			.getRequestDispatcher("board/result.jsp")
			.forward(request, response);
	}

}
