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

<form action="employeeModify.my" method="post" name ="frm">
<table border=1>
	<tr><td>직원번호</td><td><input type="text" name="empNum" value="${dto.empNum }" readonly="readonly"></td></tr>
	<tr><td>직원이름</td><td><input type="text" name="empName" value="${dto.empName }"></td></tr>
	<tr><td>아이디</td><td><input type="text" name="empId" value="${dto.empId }"></td></tr>
	<tr><td>현재 비밀번호 입력</td><td><input type="text" name="empPw" ></td></tr>
										<span style="color:red">${errPw }</span>
	<tr><td>직원주소</td><td><input type="text" name="empAddr" value="${dto.empAddr }"></td></tr>
	<tr><td>상세주소</td><td><input type="text" name="empAddrDetail" value="${dto.empAddrDetail }"></td></tr>
	<tr><td>우편번호</td><td><input type="text" name="empPost" value="${dto.empPost }"></td></tr>
	<tr><td>전화번호</td><td><input type="text" name="empPhone" value="${dto.empPhone }"></td></tr>
	<tr><td>주민번호</td><td><input type="text" name="empJumin" value="${dto.empJumin }"></td></tr>
	<tr><td>이메일</td><td><input type="text" name="empEmail" value="${dto.empEmail }"></td></tr>
	<tr><td colspan="2"><input type="submit" value="직원정보수정"></td></tr>
</table>
</form>
</body>
</html>