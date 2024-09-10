<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="memberUpdate.mem" method="post">
회원번호 : <input type="text" name="memberNum" value="${dto.memberNum }" readonly="readonly" /> <br /> 
회원이름 : <input type="text" name="memberName" value="${dto.memberName }" /> <br /> 
회원아이디 : <input type="text" name="memberId" value="${dto.memberId }"/> <br /> 
회원비밀번호 : <input type="text" name="memberPw" value="${dto.memberPw }"/> <br /> 
회원주소 : <input type="text" name="memberAddr" value="${dto.memberAddr }"/> <br /> 
회원상세주소 : <input type="text" name="memberAddrDetail" value="${dto.memberAddrDetail }" /> <br /> 
회원우편번호 : <input type="text" name="memberPost" value="${dto.memberPost }" /> <br /> 
회원성별 :  <input type="radio" name="gender" value="M" ${dto.gender == 'M' ? 'checked' : ''} />남자
		 <input type="radio" name="gender" value="F" ${dto.gender == 'F' ? 'checked' : ''} />여자 <br /> 
회원연락처1 : <input type="tel" name="memberPhone1" value="${dto.memberPhone1 }"/> <br /> 
회원연락처2 : <input type="tel" name="memberPhone2" value="${dto.memberPhone2 }"/> <br /> 
회원이메일 : <input type="email" name="memberEmail" value="${dto.memberEmail }"/> <br /> 
회원생년월일 : <input type="date" name="memberBirth" value="${dto.memberBirth }"/> <br /> 
<input type="submit" value="회원정보수정" />
</form>
</body>
</html>