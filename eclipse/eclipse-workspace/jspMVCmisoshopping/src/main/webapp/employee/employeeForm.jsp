<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="js/daumAddressScript.js"></script>
<script type="text/javascript" src="js/checkScript.js"></script>
<body>
직원등록하시게요??<br>
<form action="employeeRegist.emp" method="post">
<table border=1>
	<tr><td>직원번호</td><td><input type="text" name="empNum" value="${empNum }" readonly="readonly"></td></tr>
	<tr><td>직원이름</td><td><input type="text" name="empName"></td></tr>
	<tr><td>아이디</td><td><input type="text" name="empId" id="userId"></td></tr>
	<tr><td>비밀번호</td><td><input type="text" name="empPw"></td></tr>
	<tr><td>비밀번호확인</td><td><input type="text" name="empPwCon"></td></tr>
	<tr><td>직원주소</td><td><input type="text" name="empAddr" id="sample4_roadAddress" readonly="readonly"> <button type="button" onclick="execDaumPostcode();">주소검색</button></td></tr>
	<tr><td>상세주소</td><td><input type="text" name="empAddrDetail"></td></tr>
	<tr><td>우편번호</td><td><input type="text" name="empPost" id="sample4_postcode" readonly="readonly"></td></tr>
	<tr><td>전화번호</td><td><input type="text" name="empPhone"></td></tr>
	<tr><td>주민번호</td><td><input type="text" name="empJumin"></td></tr>
	<tr><td>이메일</td><td><input type="text" name="empEmail"></td></tr>
	<tr><td colspan="2"><input type="submit" value="직원등록"></td></tr>
</table>
</form>
</body>
</html>