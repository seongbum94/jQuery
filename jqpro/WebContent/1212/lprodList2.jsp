<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="ddit.or.kr.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	//모델1 : 요청을 받으면 비지니스 로직과 출력을 한 페이지에서 이루어진다.
	
	//sqlMapClient 객체 가져오기
	SqlMapClient smc = SqlMapClientFactory.getSqlMapClient();
	
	//mapper의 sql문 실행	
	List<LprodVO> lprodList = smc.queryForList("lprod.selectAll");
	
	//출력 jsonobject배열을 생성해서 ajax 요청으로 보낸다.
%>
<%
	for(int i = 0; i < lprodList.size(); i++){
		LprodVO lprod = lprodList.get(i);
	%>
		lprod_ID : <%=lprod.getLprod_id() %> <br>
		lprod_GU : <%=lprod.getLprod_gu() %> <br>
		lprod_NM : <%=lprod.getLprod_nm() %> <br>
		<hr color = "blue">
<%} %>

