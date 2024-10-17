<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	직원목록입니다.<br />
	<a href="employeeWrite.emp">직원등록하기</a>
	<table border=1>
	<tr><td>직원번호</td><td>직원이름</td><td>아이디</td></tr>
	<c:forEach items="${list }" var="dto">
	<tr><td> <a href="employeeDetail.emp?empNum=${dto.empNum }">${dto.empNum }</a></td><td>${dto.empName }</td><td>${dto.empId }</td></tr>
	</c:forEach>
</table>
</body>
</html>