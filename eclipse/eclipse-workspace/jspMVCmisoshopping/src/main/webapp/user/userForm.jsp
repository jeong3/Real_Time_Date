<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="js/daumAddressScript.js"></script>
<script type="text/javascript" src="js/checkScript.js"></script>
<script type="text/javascript">
	$(function() {
		$("#frm").submit(function() {
			if ($("#userPw").val() != $("#userPwCon").val()) {
				alert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
				$("#userPw").val("");
				$("#userPwCon").val("");
				$("#userPw").focus();
				return false;

			}
		});
	});
</script>
</head>
<body>
	<form action="userRegist.nhn" method="post" id="frm">
		<table border="1" align="center" width="500">
			<tr>
				<td>*아이디</td>
				<td colspan="2"><input type="text" name="memberId" id="userId" readonly="readonly"
					required="required">아이디 중복확인 </td>
			</tr>
			<tr>
				<td>*비밀번호</td>
				<td colspan="2"><input type="text" name="memberPw" id="userPw"
					required="required"></td>
			</tr>
			<tr>
				<td>*비밀번호확인</td>
				<td colspan="2"><input type="text" name="memberPwCon"
					id="userPwCon" required="required"></td>
			</tr>
			<tr>
				<td colspan="3">회원기본정보</td>
			</tr>
			<tr>
				<td>*회원이름</td>
				<td colspan="2"><input type="text" name="memberName"
					required="required"></td>
			</tr>
			<tr>
				<td>*회원 연락처1</td>
				<td colspan="2"><input type="tel" name="memberPhone1"
					required="required"></td>
			</tr>
			<tr>
				<td>*회원 연락처2</td>
				<td colspan="2"><input type="tel" name="memberPhone2"
					required="required"></td>
			</tr>
			<tr>
				<td>*회원주소</td>
				<td colspan="2"><input type="text" name="memberAddr" id="sample4_roadAddress" readonly="readonly"
					required="required"><button type="button" onclick="execDaumPostcode();">주소검색</button></td>
			</tr>
			<tr>
				<td>회원상세주소</td>
				<td colspan="2"><input type="text" name="memberAddrDetail"
					required="required"></td>
			</tr>
			<tr>
				<td>*회원우편번호</td>
				<td colspan="2"><input type="text" name="memberPost" id="sample4_postcode" readonly="readonly"
					required="required"></td>
			</tr>
			<tr>
				<td>*회원이메일</td>
				<td colspan="2"><input type="text" name="memberEmail"
					required="required"></td>
			</tr>
			<tr>
				<td>*성별</td>
				<td colspan="2">남자<input type="radio" name="gender" value='M'
					checked> 여자<input type="radio" name="gender" value='F'></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><input type="submit" value="회원가입"><input
					type="submit" value="회원가입 취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>