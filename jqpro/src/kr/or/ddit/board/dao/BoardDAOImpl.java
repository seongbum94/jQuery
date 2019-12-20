package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import ddit.or.kr.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.board.vo.BoardVO;

public class BoardDAOImpl implements IBoardDAO {
	private static BoardDAOImpl dao;
	private SqlMapClient smc;
	
	private BoardDAOImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static BoardDAOImpl getInstance() {
		if(dao == null) dao = new BoardDAOImpl();
		return dao;
	}
	
	@Override
	public List<BoardVO> selectAll() throws SQLException {
		return smc.queryForList("board.selectAll");
	}
}
