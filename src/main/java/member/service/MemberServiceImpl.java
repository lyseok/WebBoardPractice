package member.service;

import java.util.List;

import member.dao.IMemberDao;
import member.vo.MemberVO;
import member.vo.ZipVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;
	private static IMemberService instance;
	
	private MemberServiceImpl(IMemberDao dao) {
		this.dao = dao;
	}
	
	public static IMemberService getInstance(IMemberDao dao) {
		if(instance == null) instance = new MemberServiceImpl(dao);
		return instance;
	}
	
	
	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public String selectById(String id) {
		return dao.selectById(id);
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		return dao.selectByDong(dong);
	}

	@Override
	public int insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}

}
