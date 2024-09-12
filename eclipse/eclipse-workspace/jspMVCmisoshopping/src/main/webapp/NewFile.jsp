<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
session.setAttribute("a", "dd"); //저장
String name = (String) session.getAttribute("a");//다른페이지에서도 값을 가져올 수 있다. => 같은 웹브라우저 내에서!
request.setAttribute("b", "cc"); //저장
String name1 = (String) request.getAttribute("b");//현재 페이지에서만 값을 가져올 수 있다.
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=name %><br />
<%=name1 %>
<a href="next.jsp">다음페이지</a>
</body>
</html>