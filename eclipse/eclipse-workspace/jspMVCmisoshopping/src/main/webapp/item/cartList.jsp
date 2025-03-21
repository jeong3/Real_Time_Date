<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#checkBoxs").click(function() {
			if ($("#checkBoxs").prop("checked")) {
				$(":checkbox[name='prodCk']").prop("checked", true);
			} else {
				$(":checkbox[name='prodCk']").prop("checked", false);
			}
			prodChk();
		});
		$("input:checkbox[name='prodCk']").click(function() {
			var checkCnt = $("input:checkbox[name='prodCk']").length;
			var checked = $("input:checkbox[name='prodCk']:checked").length;
			;
			if (checkCnt == checked) {
				$("#checkBoxs").prop("checked", true);
				n
			} else {
				$("#checkBoxs").prop("checked", false);
			}
			prodChk();
		});
	});

	function prodChk() {
		var cnt = $(":checkbox[name='prodCk']:checked").length;
		var totalQty = 0; // 총 상품수
		var totalPrice = 0; // 총 상품금액
		var checkboxCnt = $(":checkbox[name='prodCk']").length;
		for (var idx = 0; idx < checkboxCnt; idx++) {
			if ($(":checkbox[name='prodCk']")[idx].checked) {
				totalPrice += Number($(".cartPrice:eq(" + idx + ")").text());
				totalQty += Number($(".cartQty:eq(" + idx + ")").text());
			}
		}
		$("#prodCnt").text(cnt);
		$("#totQty").text(totalQty);
		$("#totalPrice").text(totalPrice);
	}
	function goodsCartAdd(goodsNum, idx, goodsPrice) {
		option = {
			type : "post",
			url : "cart.item",
			data : {
				"goodsNum" : goodsNum,
				"cartQty" : 1
			},
			success : function() {
				$(".cartQty:eq(" + idx + ")").text(
						Number($(".cartQty:eq(" + idx + ")").text()) + 1);
				$(".cartPrice:eq(" + idx + ")").text(
						Number($(".cartPrice:eq(" + idx + ")").text())
								+ goodsPrice);
			},
			error : err,
			complete : prodChk
		};
		$.ajax(option);
	}
	function err() {
		alert("로그아웃되었습니다. 다시 로그인 하십시오.");
		window.open("loginCk.login", "loginck", "width=400,height=400");
	}
	
	function checkQty(goodsNum, idx, goodsPrice) {
		var val = $(".cartQty:eq(" + idx + ")").text();
		if (val <= 1)
			alert("최소 수량은 1개 이상이어야합니다.");
		else {
			$.ajax({
				type : "post",
				url : "cartQtyDown.item",
				data : {"goodsNum" : goodsNum },
				success : function(){
					$(".cartQty:eq(" + idx + ")").text(
							Number($(".cartQty:eq(" + idx + ")").text()) - 1);
					$(".cartPrice:eq(" + idx + ")").text(
							Number($(".cartPrice:eq(" + idx + ")").text()) - goodsPrice);
				},
				error : err,
				complete:prodChk
			});
		}
	}
	function itemDel(goodsNum){
		con = confirm("삭제하시렵니까?");
		if(con) location.href="cartItemDel.item?goodsNums="+goodsNum;
	}
	function itemsDel(){
		if($(":checked[name=prodCk]:checked").length <= 0){
			alert("적어도 하나이상 체크되어 있어야합니다.");
		}
		else{
			con = confirm("징쨔로? 삭제하시렵니까?");
			var goodsNums = "";
			if(con){
				$(":checked[name=prodCk]:checked").each(function(){
					goodsNums += $(this).val() + "-";
			});
			}
			location.href="cartItemDel.item?goodsNums="+goodsNums;
		}
	}
	function goodsCheck(){
		if($(":checkbox[name=prodCk]:checked").length <= 0){
			alert("구매할 상품을 1개 이상 선택하시오");
			return false;
		}
		
	}
</script>

</head>
<body>
<form action="itemBuy.item" method="post" onsubmit="return goodsCheck();">
	<table width="600" align="center" border="1">
		<tr>
			<td>번호</td>
			<td><input type="checkbox" id="checkBoxs" /></td>
			<td>이미지</td>
			<td>제품이름</td>
			<td>수량</td>
			<td>합계금액</td>
			<td><button type="button" onclick="itemsDel();">선택삭제</button></td>
		</tr>
		<c:forEach items="${list }" var="list" varStatus="idx">
			<tr>
				<td>${idx.count }</td>
				<td><input type="checkbox" name="prodCk" value="${list.goodsNum }" /></td>
				<td><img src="goods/upload/${list.goodsImage }" width="30" />
				</td>
				<td>${list.goodsName }</td>
				<td><a href="javascript:checkQty('${list.goodsNum }',${idx.index },${list.goodsPrice })">[-]</a> <span class="cartQty">${list.cartQty }</span>
					<a
					href="javascript:goodsCartAdd('${list.goodsNum }',${idx.index },${list.goodsPrice })">[+]</a></td>
				<td><span class="cartPrice">${list.totalPrice }</span></td>
				<td><button type="button" onclick="itemDel('${list.goodsNum}');">삭제</button></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" align="right">상품수 : <span id="prodCnt">0</span>개<br />
				총수량 : <span id="totQty">0</span>개 <br /> 
				총금액 : <span id="totalPrice">0</span>원 <br />
		</tr>
		<tr>
			<td colspan="7" align="right"> <input type="submit" value="구매하기"> </td>
		</tr>

	</table>
	</form>

</body>
</html>