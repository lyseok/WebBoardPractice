package board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.controller.SendDataSrialize;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import board.dao.BoardDaoImpl;
import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;
import board.vo.PageVO;

@WebServlet("/listBoard.do")
public class ListBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListBoard() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송데이터를 받기
		String reqData = SendDataSrialize.chageData(request);
		
		Gson gson = new Gson();
		PageVO pvo = gson.fromJson(reqData, PageVO.class);
		
		IBoardService service = BoardServiceImpl.getInstance(BoardDaoImpl.getInstance());
		
		// 게시글 3개를 가져오기 위한 정보
		PageVO vo = service.getPageInfo(pvo.getPage(), pvo.getStype(), pvo.getSword());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", vo.getStart());
		map.put("end", vo.getEnd());
		map.put("stype", pvo.getStype());
		map.put("sword", pvo.getSword());
		
		List<BoardVO> list = service.selectByPage(map);
		
		request.setAttribute("ep", vo.getEndPage());
		request.setAttribute("sp", vo.getStartPage());
		request.setAttribute("tp", vo.getTotalPage());
		request.setAttribute("list", list);
		request
			.getRequestDispatcher("/board/boardList.jsp")
			.forward(request, response);
	}

}
