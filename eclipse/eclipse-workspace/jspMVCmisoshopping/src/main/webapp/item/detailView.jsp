<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detailView.jsp</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#cartBtn").click(function(){
			if(${!empty auth}){
				$.ajax({
					type : "post",
					url : "cart.item",
					data : {"goodsNum" : "${dto.goodsNum}" , "cartQty" : $("#cartQty").val()},
					success : function(){
						con = confirm("장바구니로 이동하시겠습니까?");
						if(con){
							location.href="cartList.item";
						}else{
							document.location.reload();
						}
					},
					error : function(){
						alert("로그아웃되었습니다. 다시 로그인 하십시오.");
						window.open("loginCk.login", "loginck", "width=400, height=400");
					}
				});
			} else {
				window.open("loginCk.login","loginCk","width=400, height=400");
			}
			
		});
		
		$("#wish").click(function(){
			$.ajax({
				type : "post",
				url : "wishItem.item",
				data : {"goodsNum":"${dto.goodsNum}"},
				success : function(){
					if($("#wish").attr("src") == "images/hart1.jpg" ){
						$("#wish").attr("src", "images/hart.jpg");
					} else {
						$("#wish").attr("src", "images/hart1.jpg");
					}
				}, 
				error : function(){
					alert("다시 로그인 해주세요.");
					location.href="<c:url value = '/' />"; // /jspMVCmisoshopping
					return false;
				}
			});//ajax는 json으로 값을 전달
		}); // json : {"key":"value"}
	});
</script>
</head>
<body>
	<table width="800" align="center">
		<caption>청바지 상품정보입니다.</caption>
		<tr>
			<td rowspan="5"><img src="goods/upload/${dto.goodsMainImage }" height="200" /></td>
			
		</tr>
		<tr>
			<td> ${dto.goodsName }</td>
		</tr>
		<tr>
			<td> ${dto.goodsPrice }원</td>
		</tr>
		<tr>
			<td>조회 수 : ${dto.visitCount }</td>
		</tr>
		<tr>
			<td>수량 : <input type="number" min="1" step="1" value="1" id="cartQty" />
			</td>
		</tr>
		<tr>
			<td><button type="button" id="cartBtn">장바구니</button> |
				<button type="button" id="buyItem">바로구매</button> | 
				<c:if test="${empty isTrue }">
				<img src="images/hart1.jpg" width="20" id="wish" /> 찜</td> <!-- 비동기식 : 주소는 바뀌지 않고 일부만 바뀜 : ajax -->
				</c:if>
				<c:if test="${!empty isTrue }">
				<img src="images/hart.jpg" width="20" id="wish" /> 찜</td> <!-- 비동기식 : 주소는 바뀌지 않고 일부만 바뀜 : ajax -->
				</c:if>
		</tr>
		<tr>
			<td colspan="2"><span id="descript">제품 상세 설명</span> | 
			<span id="review">리뷰</span> | <span id="inquire" onclick="">상품문의</span></td>
		</tr>
		<tr>
			<td colspan="2"><div id="content"></div></td>
		</tr>
	</table>
</body>
</html>