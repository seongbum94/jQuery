<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String resid = (String)request.getAttribute("resid");
	String inputid = (String)request.getAttribute("inputid");
	
	if(resid == null){
	%>
		{
			"data" : "사용가능한 아이디 입니다."
		}
	<%
	} else {
	%>
		{
			"data" : "중복된 아이디가 존재합니다."
		}
	<%	
	}
%>