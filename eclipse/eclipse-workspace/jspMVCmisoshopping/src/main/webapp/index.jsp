<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	안녕하세요. 미소 쇼핑몰입니다.
	
<c:if test="${!empty auth }">
	<ul>
	<!-- 직원 -->
	<c:if test="${auth.grade == 'emp' }">
	<li> <a href="memberList.mem">회원관리</a> </li>
	<li> <a href="employeeList.emp">직원관리</a> </li>
	<li><a href="goodsList.goods">상품관리</a></li>
	<li><a href="inquire.inq">문의관리</a></li>
	<li> <a href="employeeMyPage.my">내 정보 보기</a> </li>
	<li> <a href="purchaseList.deli">회원구매정보</a> </li>
	</c:if>
	
	<!-- 회원 -->
	<c:if test="${auth.grade == 'mem' }">
	<li> <a href="memberMyPage.my">내 정보 보기</a> </li>
	<li> <a href="wishItem.item">관심상품</a></li>
	<li> <a href="cartList.item">장바구니</a></li>
	<li> <a href="purchaseList.item">주문조회</a></li>
	</c:if>
	<li> <a href="logout.login">로그아웃</a> </li>
	
	</ul>
</c:if>



<c:if test="${empty auth }">	
<form action="Login.login" method="post">
<table border="1" align="center">
   <tr><td colspan="2"> 
   <input type="checkbox" name="keepLogin" value="on" />로그인유지 |
   <input type="checkbox" name="storeId" value="store" <c:if test="${!empty sid }">checked</c:if>/> 아이디저장 </td></tr>
   <tr><td>
         <input type="text" name="userId" placeholder="아이디" value="${sid }"/>
         <div style="color:red" >${errId }</div>
      </td>
      <td rowspan="2">
         <input type="submit" value="로그인" />
      </td></tr>
   <tr><td>
         <input type="password" name="userPw" placeholder="비밀번호" />
         <div style="color:red" >${errPw }</div>
      </td></tr>
   <tr><td colspan="2">
      	 <a href="idInquiry.help">아이디</a> /
       	 <a href="pwInquiry.help">비밀번호 찾기</a> |
         <a href="userAgree.nhn">회원가입</a>
      </td></tr>
</table>   
</form>
</c:if>
<table width="800" align="center">
   <tr>
      <c:forEach items="${list }" var="list" varStatus="idx">
      <td> 
      <a href="detailView.item?goodsNum=${list.goodsNum }">
      <img src="goods/upload/${list.goodsMainImage }" width="300" height="150"/><br />
         상품이름 : ${list.goodsName }<br/>
         상품가격 : ${list.goodsPrice }<br />
         </a>
      </td>
      <c:if test="${idx.count % 3 == 0 }"></tr><tr></c:if>
      </c:forEach>
   </tr>
</table>


</body>
</html>