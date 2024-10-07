<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="800" align="center">
		<tr>
			<td>아이디 | 작성일</td>
		</tr>
		<tr>
			<td>내용 <hr></td>
		</tr>
		<c:forEach items="${list }" var="dto">
		<tr>
			<td>${dto.memberId } | ${dto.reviewDate }</td>
		</tr>
		<tr>
			<td>${fn:replace(dto.reviewContent, newLine, '<br />')}  <hr></td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>