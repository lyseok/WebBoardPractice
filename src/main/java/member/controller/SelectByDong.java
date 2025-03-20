package member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.dao.MemberDaoImpl;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.ZipVO;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

/**
 * Servlet implementation class SelectByDong
 */
@WebServlet("/selectByDong.do")
public class SelectByDong extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송데이터 읽기
		
		String sendData = SendDataSrialize.chageData(request);
		
		// 자바 객체로 역직렬화
		Gson gson = new Gson();
		ZipVO vo = gson.fromJson(sendData, ZipVO.class);
		
		IMemberService service = MemberServiceImpl.getInstance(MemberDaoImpl.getInstace());
		
		List<ZipVO> list = service.selectByDong(vo.getDong());
		
		request.setAttribute("zipList", list);
		
		request
			.getRequestDispatcher("/0312/view/dongList.jsp")
			.forward(request, response);
	}

}
