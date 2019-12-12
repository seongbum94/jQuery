<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="ddit.or.kr.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[   
<%
	//모델1 : 요청을 받으면 비지니스 로직과 출력을 한 페이지에서 이루어진다.
	
	//sqlMapClient 객체 가져오기
	SqlMapClient smc = SqlMapClientFactory.getSqlMapClient();
	
	List<LprodVO> list = smc.queryForList("lprod.selectAll");
	
	for(int i = 0; i < list.size(); i++){
		LprodVO vo = list.get(i);
		if(i > 0) out.print(",");
		%>
			{
				"id" : <%=vo.getLprod_id() %>,
				"gu" : <%=vo.getLprod_gu() %>,
				"nm" : <%=vo.getLprod_nm() %>
			}
		<%
	}
%>
]