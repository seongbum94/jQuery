<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="ddit.or.kr.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SqlMapClient smc = SqlMapClientFactory.getSqlMapClient();
	String id = request.getParameter("id");
	
	BuyerVO buyer = (BuyerVO)smc.queryForObject("buyer.buyerDetail", id);
	
	if(buyer != null){
		%>
			{
				"id" : "<%=buyer.getBuyer_id() %>",
				"name" : "<%=buyer.getBuyer_name() %>",
				"bank" : "<%=buyer.getBuyer_bank() %>",		
				"bankNO" : "<%=buyer.getBuyer_bankno() %>",
				"bankName" : "<%=buyer.getBuyer_bankname() %>",
				"zip" : "<%=buyer.getBuyer_zip() %>",
				"addr" : "<%=buyer.getBuyer_add1() + buyer.getBuyer_add2()%>",
				"comTel" : "<%=buyer.getBuyer_comtel()%>",
				"fax" : "<%=buyer.getBuyer_fax()%>",
				"addr" : "<%=buyer.getBuyer_add1() + buyer.getBuyer_add2()%>"
			}
		<%
	}
%>