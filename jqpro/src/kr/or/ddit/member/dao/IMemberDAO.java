package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberDAO {
	public String checkId(String id) throws SQLException;
	
	public List<ZipVO> searchDong(String dong) throws SQLException;
	
	public String insertMember(MemberVO member) throws SQLException;
}
