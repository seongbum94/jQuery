package kr.or.ddit.lprod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDAO;
import kr.or.ddit.lprod.dao.LProdDAOImpl;
import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.lprod.vo.ProdVO;

//필요한거 : dao
//controller에서 사용할 자기의 객체
public class LprodServiceImpl implements ILprodService {
	private ILprodDAO dao;
	private static LprodServiceImpl service;
	
	private LprodServiceImpl() {
		dao = LProdDAOImpl.getInstance();
	}
	
	public static LprodServiceImpl getInstance() {
		if(service == null) service = new LprodServiceImpl();
		return service;
	}
	
	@Override
	public List<LprodVO> selectLprod() {
		List<LprodVO> list = null;
		try {
			list = dao.selectLprod();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProdVO> selectProd(String lprod_gu) {
		List<ProdVO> list = null;
		try {
			list = dao.selectProd(lprod_gu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ProdVO prodDetail(String prod_id) {
		ProdVO vo = null;
		try {
			vo = dao.prodDetail(prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
}
