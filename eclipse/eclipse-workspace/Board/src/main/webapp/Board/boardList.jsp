<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "java.util.List, board.model.BoardDTO"  %>
<%
	List<BoardDTO> list = (List<BoardDTO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	게시판 리스트
	<br />
	<table border="1" width="600">
		<tr>
			<td>번호</td>
			<td>글쓴이</td>
			<td>제목</td>
		</tr>
		<% for(BoardDTO dto : list){ %>
		<tr><td><%=dto.getBoardNum() %></td><td><%=dto.getBoardWriter() %></td><td><%=dto.getBoardSubject() %></td></tr>
			<%  } %>
		<tr>
			<td>번호</td>
			<td>글쓴이</td>
			<td>제목</td>
		</tr>
	</table>
</body>
</html>