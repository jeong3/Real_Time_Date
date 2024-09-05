<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	게시글리스트
	<br />
	<a href="boardWrite.com">게시글쓰기</a>
	<br />
	<table border="1">
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td> <a href="boardDetail.com?boardNum=${dto.boardNum }"> ${dto.boardNum }</a></td>
				<td>${dto.boardWriter }</td>
				<td>${dto.boardSubject }</td>
			</tr>
		</c:forEach>
	</table>
	
	
	


</body>
</html>