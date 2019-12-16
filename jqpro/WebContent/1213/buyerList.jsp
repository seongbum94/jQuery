<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="ddit.or.kr.ibatis.config.SqlMapClientFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
[
<%
	//sqlMapClient객체 가져오기
	SqlMapClient smc = new SqlMapClientFactory().getSqlMapClient();

	//sql문 수행하기 - 결과값(list) 받기
	List<BuyerVO> buyerList = smc.queryForList("buyer.selectNames");
	
	//결과 값을 출력(json)
	for(int i = 0; i < buyerList.size(); i++){
		BuyerVO buyer = buyerList.get(i);
		if(i > 0) out.println(",");
		%>
			{
				"id" : "<%=buyer.getBuyer_id() %>",
				"name" : "<%=buyer.getBuyer_name() %>"
			}		
		<%
	}
%>
]