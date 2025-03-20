package board.service;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;
import board.vo.PageVO;
import board.vo.ReplyVO;

public interface IBoardService {

	/***
	 * 전체 글 갯수 가져오기
	 * @param map - stype, sword
	 * @return int
	 */
	public int totalCount(Map<String, Object> map);
	
	/***
	 * 페이지별 리스트 가져오기
	 * @param map - stype, sword, start, end
	 * @return List<BoardVO>
	 */
	public List<BoardVO> selectByPage(Map<String, Object> map);
	
	// 페이지별 리스트 가져오기 위한 정보 구하기 - start, end, stype, sword
	public PageVO getPageInfo(int page, String type, String word);
	
	public int insertBoard(BoardVO vo);
	
	public int updateBoard(BoardVO vo);
	
	public int deleteBoard(int no);
	
	public int insertReply(ReplyVO vo);
	
	public int updateReply(ReplyVO vo);
	
	public int deleteReply(int no);
	
	public List<ReplyVO> selectReply(int boNo);
	
	public int updateHitBoard(int boNo);
	
}

