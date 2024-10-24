<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function ipgoUpdate(){
	location.href="goodsIpgoUpdate.ipgo?ipgoNum=${ipgodto.ipgoNum }";
}
function ipgoDelte(){
	location.href="goodsIpgoDelete.ipgo?ipgoNum=${ipgodto.ipgoNum }";
}
</script>
</head>
<body>
입고번호 : ${ipgodto.ipgoNum }<br />
상품번호 : ${ipgodto.goodsNum }<br />
입고일 : ${ipgodto.ipgoDate }<br />
입고 수량 : ${ipgodto.ipgoQty }<br />
제조일 : ${madeDate } <br />
가격 : ${ipgodto.ipgoPrice }<br />
등록한 사원 : ${ipgodto.empNum }<br />
<button type="button" onclick="ipgoUpdate()">입고 수정</button> | 
<button type="button" onclick="ipgoDelte()">입고 삭제</button>
</body>
</html>