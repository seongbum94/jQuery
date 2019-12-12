<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="ddit.or.kr.ibatis.config.SqlMapClientFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
	//모델1 : 요청을 받으면 비지니스 로직과 출력을 한 페이지에서 이루어진다.
	
	//sqlMapClient 객체 가져오기
	SqlMapClient smc = SqlMapClientFactory.getSqlMapClient();
	
	//mapper의 sql문 실행	
	List<MemberVO> memList = smc.queryForList("member.selectAll");
	
	//출력 jsonobject배열을 생성해서 ajax 요청으로 보낸다.
	
	for(int i = 0; i < memList.size(); i++){
		MemberVO member = memList.get(i);
		if(i > 0) out.print(",");
		%>
			{
				"id"    : "<%=member.getMem_id() %>",
				"pass"  : "<%=member.getMem_pass() %>",
				"name"  : "<%=member.getMem_name() %>",
				"bir"   : "<%=member.getMem_bir() %>",
				"zip"   : "<%=member.getMem_zip() %>",
				"add1"  : "<%=member.getMem_add1() %>",
				"add2"  : "<%=member.getMem_add2() %>",
				"hp"    : "<%=member.getMem_hp() %>",
				"email" : "<%=member.getMem_mail() %>"
			}
		<%
	}
%>
]