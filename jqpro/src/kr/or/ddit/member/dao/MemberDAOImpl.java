package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import ddit.or.kr.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

//sqlMapClient가 필요 - sqlMapClientFactory 얻어오기
//service에서 사용할 자신의 객체 IMemberDAO객체를 생성하고 리턴한다.

public class MemberDAOImpl implements IMemberDAO {
	
	private SqlMapClient smc;
	private static MemberDAOImpl dao;
	
	private MemberDAOImpl() {
		smc = SqlMapClientFactory.getSqlMapClient(); 
	}
	
	public static IMemberDAO getInstance() {
		if(dao == null) dao = new MemberDAOImpl();
		return dao;
	}
	
	@Override
	public String checkId(String id) throws SQLException {
		return (String)smc.queryForObject("member.checkId", id);
	}

	@Override
	public List<ZipVO> searchDong(String dong) throws SQLException {
		return smc.queryForList("member.searchDong", dong);
	}

	@Override
	public String insertMember(MemberVO member) throws SQLException {
		return (String) smc.insert("member.insertMember", member);
	}

}
