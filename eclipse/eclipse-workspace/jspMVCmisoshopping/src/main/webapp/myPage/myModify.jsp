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
mymodify.jsp
		<ul>
		
		<li> <a href="<c:url value='/' />">홈</a></li>
		<li> <a href="memberMyPage.my">내정보 보기</a></li>
		<li><a href="memberUpdate.my">내정보 수정</a></li>
		<li><a href="userPwModify.my">비밀번호 변경</a></li>
		<li><a href="memberDrop.my">회원탈퇴</a></li>
	</ul>
<form action="memberModify.my" method="post" name ="frm">
회원이름 : <input type="text" name="memberName" value="${dto.memberName }" /> <br /> 
회원아이디 : <input type="text" name="memberId" value="${dto.memberId }" readonly="readonly" /> <br /> 
현재 비밀번호 입력 : <input type="password" name="memberPw"><br /> 
				<span style="color:red">${errPw }</span>
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