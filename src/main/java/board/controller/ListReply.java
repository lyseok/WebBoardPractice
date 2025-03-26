package board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import board.dao.BoardDaoImpl;
import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.ReplyVO;

/**
 * Servlet implementation class ListReply
 */
@WebServlet("/listReply.do")
public class ListReply extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송데이터 받기
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		IBoardService service = BoardServiceImpl.getInstance(BoardDaoImpl.getInstance());
		
		List<ReplyVO> list = service.selectReply(bonum);
		System.out.println("listsize"+list.size());
		request.setAttribute("list", list);
		
		request
			.getRequestDispatcher("/board/replyList.jsp")
			.forward(request, response);
		
	}

}
