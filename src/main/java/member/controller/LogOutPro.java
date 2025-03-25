package member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import member.vo.MemberVO;

import java.io.IOException;

/**
 * Servlet implementation class LogOutPro
 */
@WebServlet("/logOutPro.do")
public class LogOutPro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hsess = request.getSession();
		
		MemberVO vo = (MemberVO)hsess.getAttribute("loginok");
		
		if(vo != null) {
			hsess.removeAttribute("loginok");
			hsess.removeAttribute("check");
		}
		
		request
			.getRequestDispatcher("/start/logpro.jsp")
			.forward(request, response);
	}

}
