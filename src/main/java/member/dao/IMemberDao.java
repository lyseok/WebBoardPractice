package member.dao;

import java.util.List;

import member.vo.MemberVO;
import member.vo.ZipVO;

public interface IMemberDao {
	public List<MemberVO> getAllMember();
	// 아이디 중복 검사
	public String selectById(String id);
	
	public List<ZipVO> selectByDong(String dong);
	
	public int insertMember(MemberVO vo);
}
