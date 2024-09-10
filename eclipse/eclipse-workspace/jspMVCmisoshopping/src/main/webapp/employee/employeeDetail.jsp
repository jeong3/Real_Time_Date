<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
	<a href="employeeModify.emp?empNum=${dto.empNum }">수정</a>  |  <a href="employeeDelete.emp?empNum=${dto.empNum }">삭제</a>
	|  <a href="employeeList.emp">리스트이동</a>
</body>
</html>