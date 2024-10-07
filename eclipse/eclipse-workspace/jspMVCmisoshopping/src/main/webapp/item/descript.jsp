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
			<td>
			${fn:replace(dto.goodsContents, newLine, '<br />')} 
			<br /> 
			<c:forTokens items="${dto.goodsDetailStoreImage }" delims="`" var="img">
			<img src="goods/upload/${img }">
			</c:forTokens>
			 
			</td>
		</tr>
	</table>
</body>
</html>