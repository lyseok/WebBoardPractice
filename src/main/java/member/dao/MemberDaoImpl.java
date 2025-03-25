package member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import member.vo.MemberVO;
import member.vo.ZipVO;
import myBatis.config.MyBatisUtil;

public class MemberDaoImpl implements IMemberDao {
	private static IMemberDao instance;
	
	private MemberDaoImpl() { }
	
	public static IMemberDao getInstace() {
		if(instance == null) instance = new MemberDaoImpl();
		return instance;
	}
	
	@Override
	public List<MemberVO> getAllMember() {
		SqlSession session = null;		
		List<MemberVO> list = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			list = session.selectList("member.getAllMember");			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return list;
	}

	@Override
	public String selectById(String id) {
		SqlSession session = null;
		String memId = null;
		try {
			session = MyBatisUtil.getSqlSession();
			memId = session.selectOne("member.selectById", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return memId;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		SqlSession session = null;
		List<ZipVO> list = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			list = session.selectList("zip.selectByDong",dong);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return list;
	}

	
	@Override
	public int insertMember(MemberVO vo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MyBatisUtil.getSqlSession();
			cnt = session.insert("member.insertMember", vo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return cnt;
	}

	@Override
	public MemberVO loginProcess(Map<String, String> map) {
		SqlSession session = null;
		MemberVO vo = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			vo = session.selectOne("member.loginProcess", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return vo;
	}

}
