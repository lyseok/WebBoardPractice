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

@WebServlet("/deleteReply.do")
public class DeleteReply extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("renum"));
		
		IBoardService service = BoardServiceImpl.getInstance(BoardDaoImpl.getInstance());
		
		int res = service.deleteReply(num);
		
		request.setAttribute("result", res);
		
		// view 페이지로 이동
		request
			.getRequestDispatcher("board/result.jsp")
			.forward(request, response);
				
	}

}
