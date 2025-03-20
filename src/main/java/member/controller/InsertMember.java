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

import com.google.gson.Gson;

/**
 * Servlet implementation class InsertMember
 */
@WebServlet("/insertMember.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sendData = SendDataSrialize.chageData(request);
		
		System.out.println(sendData);
		
		// 역직렬화
		
		Gson gson = new Gson();
		MemberVO vo = gson.fromJson(sendData, MemberVO.class);
		
		IMemberService service = MemberServiceImpl.getInstance(MemberDaoImpl.getInstace());
		int res = service.insertMember(vo);
		
		request.setAttribute("result", res);
		
		request
			.getRequestDispatcher("/0312/view/result.jsp")
			.forward(request, response);
		
	}

}
