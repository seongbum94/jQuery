<%@page import="ddit.or.kr.ibatis.config.SqlMapClientFactory"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//모델1 : 요청을 받으면 비지니스 로직과 출력을 한 페이지에서 이루어진다.
	
	//sqlMapClient 객체 가져오기
	SqlMapClient smc = SqlMapClientFactory.getSqlMapClient();
	
	//mapper의 sql문 실행	
	List<MemberVO> memList = smc.queryForList("member.selectAll");
	
	//출력 jsonobject배열을 생성해서 ajax 요청으로 보낸다.
%>
	<table border = "1">
		<tr id = "tr1">
			<td>id</td>
			<td>pass</td>
			<td>name</td>
			<td>bir</td>
			<td>zip</td>
			<td>add1</td>
			<td>add2</td>
			<td>hp</td>
			<td>email</td>
		</tr>
	<%
		for(int i = 0; i < memList.size(); i++){
			MemberVO member = memList.get(i);
 	%>
				<tr>
					<td><%=member.getMem_id() %></td>
					<td><%=member.getMem_pass() %></td> 
					<td><%=member.getMem_name() %></td> 
					<td><%=member.getMem_bir() %></td>  
					<td><%=member.getMem_zip() %></td>  
					<td><%=member.getMem_add1() %></td> 
					<td><%=member.getMem_add2() %></td> 
					<td><%=member.getMem_hp() %></td>   
					<td><%=member.getMem_mail() %></td>
				</tr>
	<%} %>
	</table>
