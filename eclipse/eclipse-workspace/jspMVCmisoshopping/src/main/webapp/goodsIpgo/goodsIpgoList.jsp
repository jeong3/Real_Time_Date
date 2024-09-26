<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsIpgoList.jsp</title>
</head>
<body>
<a href="<c:url value='/' />">홈</a>
<ul>
	<li><a href="goodsWrite.goods">상품 추가</a></li>
	<li><a href="goodsIpgo.ipgo">상품 입고</a></li>
	<li><a href="goodsIpgoList.ipgo">상품 입고 현황</a></li>
	<li><a href="goodsList.goods">상품목록</a></li>
</ul>
<table border=1 width="600" align="center">
	<caption>입고현황</caption>
	<tr><td>번호</td><td>입고번호</td><td>상품번호</td><td>상품입고가격</td><td>수량</td><th>입고일</th></tr>
	<c:set var="i" value="1"></c:set>
	<c:forEach items="${ipgoList }" var="ipgoList">
	<tr><td> <a href="goodsDetail.ipgo?ipgoNum=${ipgoList.ipgoNum }">${i }</a></td><td>${ipgoList.ipgoNum }</td><td>${ipgoList.goodsNum }</td><td>${ipgoList.ipgoPrice }</td><td>${ipgoList.ipgoQty }</td><th>${ipgoList.ipgoDate }</th></tr>
	<c:set var="i" value="${i+1 }"></c:set>
	</c:forEach>


</table>
</body>
</html>