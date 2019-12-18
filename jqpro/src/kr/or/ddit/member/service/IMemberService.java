package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService {
	public String checkId(String id);
	
	public List<ZipVO> searchDong(String dong);
	
	public String insertMember(MemberVO member);
}
