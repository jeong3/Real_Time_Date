<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsList.jsp</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type="text/javascript">

$(function(){
    $(".btn").click(function(){
    	// 클릭된 버튼이 속한 tr에서 .goodsNum 값을 가져옴
        var goodsNum = $(this).closest('tr').find(".goodsNum").html();
        var goodsName = $(this).closest('tr').find(".goodsName").html();
        $(opener.document).find("#goodsNum").val(goodsNum); // 부모 창(#)에 값 할당
        $(opener.document).find("#goodsName").val(goodsName);
        window.self.close(); // 팝업창 닫기
    });
});
</script>
</head>
<body>
<table border=1 width="600" align="center">
	<caption>상품 목록</caption>
	<tr><th>번호</th><th>상품번호</th><th>상품명</th><th>상품가격</th></tr>
	<c:set var="i" value="1"></c:set>
	<c:forEach items="${list }" var="dto">
	<tr><th><a href="#" class="btn">${i }</a></th><th class="goodsNum">${dto.goodsNum }</th><th class="goodsName">${dto.goodsName}</th><th>${dto.goodsPrice }</th></tr>
	<c:set var="i" value="${i+1 }"></c:set>
	</c:forEach>
</table>
</body>
</html>