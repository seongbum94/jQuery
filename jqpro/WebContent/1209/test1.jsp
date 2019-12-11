<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "../js/jquery-3.4.1.min.js"></script>
<link rel = "stylesheet" href = "../css/mycss.css"></link>
<style>
	p{
		font-size : 1.5em;
		color : blue;
	}
	h1{
		color : orange;
	}
</style>
</head>
<body>
	<%
		//클라이언트 폼에서 입력하고 전달된 값을 받는다
		//post일 경우 - 인코딩
		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("name");
		String userTel = request.getParameter("tel");
	%>
	<p><%=userName%>님 환영합니다.</p>
	<h1>즐거운 하루 되세요</h1>
</body>
</html>





