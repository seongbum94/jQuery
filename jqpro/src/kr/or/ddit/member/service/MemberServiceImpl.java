package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

//dao객체가 필요 - getInstance
//controller에서 사용할 자신의 객체

public class MemberServiceImpl implements IMemberService {
	private IMemberDAO dao;
	private static IMemberService service;
	
	private MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	
	public String checkId(String id) {
		String sid = null;
		
		try {
			sid = dao.checkId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sid;
	}

	@Override
	public List<ZipVO> searchDong(String dong) {
		List<ZipVO> list = null;
		try {
			list = dao.searchDong(dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String insertMember(MemberVO member) {
		String resid = null;
		try {
			resid = dao.insertMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resid;
	}
}
