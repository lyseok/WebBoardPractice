package board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardVO;
import board.vo.ReplyVO;
import myBatis.config.MyBatisUtil;

public class BoardDaoImpl implements IBoardDao {
	private static IBoardDao instance;
	
	private BoardDaoImpl() { }
	
	public static IBoardDao getInstance() {
		if(instance == null) instance = new BoardDaoImpl();
		return instance;
	}
	
	
	@Override
	public int totalCount(Map<String, Object> map) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MyBatisUtil.getSqlSession();
			cnt = session.selectOne("board.totalCount", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		SqlSession session = null;
		List<BoardVO> list = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			list = session.selectList("board.selectByPage", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return list;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MyBatisUtil.getSqlSession();
			cnt = session.insert("board.insertBoard", vo);
			
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		SqlSession session = null;
		int cnt = 0;

		try {
			session = MyBatisUtil.getSqlSession();
			cnt = session.update("board.updateBoard", vo);
			
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int no) {
		SqlSession session = null;
		int cnt = 0;

		try {
			session = MyBatisUtil.getSqlSession();
			cnt = session.delete("board.deleteBoard", no);
			
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MyBatisUtil.getSqlSession();
			cnt = session.insert("reply.insertReply", vo);
			
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MyBatisUtil.getSqlSession();
			cnt = session.insert("reply.updateReply", vo);
			
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteReply(int no) {
		SqlSession session = null;
		int cnt = 0;

		try {
			session = MyBatisUtil.getSqlSession();
			cnt = session.insert("reply.deleteReply", no);
			
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return cnt;
	}

	@Override
	public List<ReplyVO> selectReply(int boNo) {
		SqlSession session = null;
		List<ReplyVO> list = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			list = session.selectList("reply.seleteReply", boNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return list;
	}

	@Override
	public int updateHitBoard(int boNo) {
		SqlSession session = null;
		int cnt = 0;

		try {
			session = MyBatisUtil.getSqlSession();
			cnt = session.update("board.updateHitBoard", boNo);
			
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return cnt;
	}

}
