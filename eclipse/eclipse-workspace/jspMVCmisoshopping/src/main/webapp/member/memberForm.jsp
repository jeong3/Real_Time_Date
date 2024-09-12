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
회원 등록 폼입니다.

<form action="memberRegist.mem" method="post">
회원번호 : <input type="text" name="memberNum" value="${memberNum }" readonly="readonly" /> <br /> 
회원이름 : <input type="text" name="memberName" /> <br /> 
회원아이디 : <input type="text" name="memberId" id="userId" /> <br /> 
회원비밀번호 : <input type="text" name="memberPw" /> <br /> 
회원비밀번호확인 : <input type="text" name="memberPwcon" /> <br /> 
회원주소 : <input type="text" name="memberAddr" id="sample4_roadAddress" readonly="readonly"/><button type="button" onclick="execDaumPostcode();">주소검색</button> <br /> 
회원상세주소 : <input type="text" name="memberAddrDetail" /> <br /> 
회원우편번호 : <input type="text" name="memberPost" id="sample4_postcode" readonly="readonly" /> <br /> 
회원성별 : <input type="checkbox" name="gender" value="M" />남자
<input type="checkbox" name="gender" value="F" />여자 <br /> 
회원연락처1 : <input type="tel" name="memberPhone1" /> <br /> 
회원연락처2 : <input type="tel" name="memberPhone2" /> <br /> 
회원이메일 : <input type="email" name="memberEmail" /> <br /> 
회원생년월일 : <input type="date" name="memberBirth" /> <br /> 
<input type="submit" value="회원등록" >
</form>

</body>
</html>