package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDAO {
	public List<BoardVO> selectAll() throws SQLException;
}
