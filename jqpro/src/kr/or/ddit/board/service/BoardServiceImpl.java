package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.dao.BoardDAOImpl;
import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	private IBoardDAO dao;
	
	private static IBoardService service;
	
	private BoardServiceImpl() {
		dao = BoardDAOImpl.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}
	
	@Override
	public List<BoardVO> selectAll(){
		List<BoardVO> list = null;
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
