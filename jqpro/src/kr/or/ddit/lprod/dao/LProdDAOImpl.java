package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import ddit.or.kr.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.lprod.vo.ProdVO;


//필요한거 - SqlMapClient
//service에서 사용할 자기의 객체
public class LProdDAOImpl implements ILprodDAO{
	private SqlMapClient smc;
	private static ILprodDAO dao; //다형성 때문에 ILProdDAO타입으로 만든다
	
	private LProdDAOImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static ILprodDAO getInstance() {
		if(dao == null) dao = new LProdDAOImpl();
		return dao;
	}
	
	@Override
	public List<LprodVO> selectLprod() throws SQLException {
		return smc.queryForList("lprod.selectAll");
	}

	@Override
	public List<ProdVO> selectProd(String lprod_gu) throws SQLException {
		return smc.queryForList("prod.selectProd",lprod_gu);
	}

	@Override
	public ProdVO prodDetail(String prod_id) throws SQLException {
		return (ProdVO)smc.queryForObject("prod.prodDetail", prod_id);
	}

}
