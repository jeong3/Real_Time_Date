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
<ul>
		<li> <a href="<c:url value='/' />">홈</a></li>
		<li><a href="memberList.mem">회원관리</a></li>
		<li><a href="employeeList.emp">직원관리</a></li>
		<li><a href="goodsList.goods">상품관리</a></li>
		<li><a href="employeeMyPage.my">내 정보 보기</a></li>
		<li><a href="employeeUpdate.my">내정보 수정</a></li>
		<li><a href="employeePwUpdate.my">비밀번호 변경</a></li>
	</ul>
	
	<form action="employeePwModify.my" method="post">
		비밀번호 확인 :<input type="password" name="empPw" required="required" />
				<div style="color:red">${errPw }</div>
					<input type="submit" value="확인" />
	</form>
</body>
</html>