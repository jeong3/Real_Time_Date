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
${dto }
	<ul>
	<li> <a href="<c:url value='/' />">홈</a></li>
		<li><a href="memberList.mem">회원관리</a></li>
		<li><a href="employeeList.emp">직원관리</a></li>
		<li><a href="goodsList.goods">상품관리</a></li>
		<li><a href="employeeMyPage.my">내 정보 보기</a></li>
		<li><a href="employeeUpdate.my">내정보 수정</a></li>
		<li><a href="employeePwUpdate.my">비밀번호 변경</a></li>
	</ul>
	
	<table border=1>
	<tr><td>직원번호</td><td>${dto.empNum }</td></tr>
	<tr><td>직원이름</td><td>${dto.empName }</td></tr>
	<tr><td>아이디</td><td>${dto.empId }</td></tr>
	<tr><td>비밀번호</td><td>${dto.empPw }</td></tr>
	<tr><td>비밀번호확인</td><td>${dto.empPw }</td></tr>
	<tr><td>직원주소</td><td>${dto.empAddr }</td></tr>
	<tr><td>상세주소</td><td>${dto.empAddrDetail }</td></tr>
	<tr><td>우편번호</td><td>${dto.empPost }</td></tr>
	<tr><td>전화번호</td><td>${dto.empPhone }</td></tr>
	<tr><td>주민번호</td><td>${dto.empJumin }</td></tr>
	<tr><td>이메일</td><td>${dto.empEmail }</td></tr>
</table>
</body>
</html>