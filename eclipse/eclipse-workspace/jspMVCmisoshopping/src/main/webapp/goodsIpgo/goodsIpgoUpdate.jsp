<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="goodsIpgoModify.ipgo" method="post">
입고번호 : <input type="text" name="goodsIpgoNum" readonly="readonly" 
				value="${ipgodto.ipgoNum }"/><br />
상품번호 : <input type="text" name="goodsNum" readonly="readonly" 
				value="${ipgodto.goodsNum }"/><br />
입고일 : <input type="date" name="ipgoDate" value="${ipgodto.ipgoDate }" /><br />
입고 수량 : <input type="number" name="ipgoQty" value="${ipgodto.ipgoQty }"/><br />
제조일 : <input type="datetime-local" name="madeDate" value="${madeDate }"/><br />
가격 : <input type="number" name="ipgoPrice" value="${ipgodto.ipgoPrice }"/><br />
등록한 사원 : <input type="text"  value="${ipgodto.empNum }" readonly="readonly"/><br />
<input type="submit" value="수정완료" />
</form>
</body>
</html>