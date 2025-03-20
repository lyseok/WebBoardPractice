package member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.dao.MemberDaoImpl;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class MemberList
 */
@WebServlet("/memberList.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// service객체 얻기
		IMemberService service = MemberServiceImpl.getInstance(MemberDaoImpl.getInstace());
		
		// service 메소드 호출하기 - 결과값 받기
		List<MemberVO> list = service.getAllMember();
		
		// 결과값 request에 저장
		request.setAttribute("list", list);
		
		// view 페이지로 이동
		request
			.getRequestDispatcher("/0312/view/memberList.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
