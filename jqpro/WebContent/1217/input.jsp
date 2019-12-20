<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String resid = (String)request.getAttribute("resid");
	
	if(resid != null){
	%>
		{
			"data" : "<%=resid%>님 환영합니다."
		}
	<%
	} else {
	%>
		{
			"data" : "가입실패"
		}
	<%	
	}
%>