<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String desc = request.getParameter("desc");
	String item = request.getParameter("item");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : <%= userId %> <br />
패스워드 : <%= userPw %><br />
자기소개서 : <%= desc %><br />
item :  <%= item %><br />
</body>
</html>