package member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import member.dao.MemberDaoImpl;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * Servlet implementation class LoginProcess
 */
@WebServlet("/loginProcess.do")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  reqData = SendDataSrialize.chageData(request);
		
		Gson gson = new Gson();
		
		MemberVO vo = gson.fromJson(reqData, MemberVO.class);
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(vo.getMem_id());
		System.out.println(vo.getMem_pass());
		map.put("mem_id", vo.getMem_id());
		map.put("mem_pass", vo.getMem_pass());
		
		IMemberService service = MemberServiceImpl.getInstance(MemberDaoImpl.getInstace());
		MemberVO memVo = service.loginProcess(map);
		
		HttpSession hsession = request.getSession();
		
		if(memVo != null) {
			hsession.setAttribute("loginok", memVo);
			hsession.setAttribute("check", "true");
		} else {
			hsession.setAttribute("check", "false");
		}
		
		request
			.getRequestDispatcher("/start/logpro.jsp")
			.forward(request, response);
	}

}
