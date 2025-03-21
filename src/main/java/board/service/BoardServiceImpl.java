package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.dao.IBoardDao;
import board.vo.BoardVO;
import board.vo.PageVO;
import board.vo.ReplyVO;

public class BoardServiceImpl implements IBoardService {
	private static IBoardService instance;
	private IBoardDao dao;
	
	private BoardServiceImpl(IBoardDao dao) {
		this.dao = dao;
	}
	
	public static IBoardService getInstance(IBoardDao dao) {
		if(instance == null) instance = new BoardServiceImpl(dao);
		return instance;
	}
	
	
	
	@Override
	public int totalCount(Map<String, Object> map) {
		return dao.totalCount(map);
	}

	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		return dao.selectByPage(map);
	}

	@Override
	public int insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.insertBoard(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.updateBoard(vo);
	}

	@Override
	public int deleteBoard(int no) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(no);
	}

	@Override
	public int insertReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return dao.insertReply(vo);
	}

	@Override
	public int updateReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return dao.updateReply(vo);
	}

	@Override
	public int deleteReply(int no) {
		// TODO Auto-generated method stub
		return dao.deleteReply(no);
	}

	@Override
	public List<ReplyVO> selectReply(int boNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateHitBoard(int boNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageVO getPageInfo(int page, String type, String word) {
		int perList = PageVO.getPerList();
		
		// 전체글 갯수 가져오기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stype", type);
		map.put("sword" , word);
		int count = this.totalCount(map);
		
		// 전체 페이지 수 구하기
		int totalPage = (int)Math.ceil((double)count / perList);
		
		// start, end값 구하기 - 글 리스트의 시작과 끝 번호
		
		int start = (page - 1) * perList + 1;
		int end = start + perList - 1;
		
		if(end > count) end = count;
		
		//startPage와 endPage를 구하기
		int perPage = PageVO.getPerPage();
		int startPage = ((page-1) / perPage * perPage) + 1;
		int endPage = startPage + perPage - 1;
		if(endPage > totalPage) endPage = totalPage;
		
		
		PageVO vo = new PageVO();
		
		// 값 설정
		vo.setStart(start);
		vo.setEnd(end);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		vo.setTotalPage(totalPage);
		
		
		return vo;
	}

}
