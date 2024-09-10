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
회원 상세페이지입니다.<br />
회원번호 : ${dto.memberNum }<br />
회원이름 : ${dto.memberName } <br />
회원아이디 : ${dto.memberId }<br />
회원비밀번호 : ${dto.memberPw }<br />
회원주소 : ${dto.memberAddr }<br />
회원상세주소 : ${dto.memberAddrDetail }<br />
회원우편번호 : ${dto.memberPost }<br />
회원성별 : <c:if test="${dto.gender == 'M' }">남자</c:if> 
		 <c:if test="${dto.gender == 'F' }">여자</c:if><br />
회원연락처1 : ${dto.memberPhone1 }<br />
회원연락처2 : ${dto.memberPhone2 }<br />
회원이메일 : ${dto.memberEmail }<br />
회원생년월일 : ${dto.memberBirth }<br />
회원등록일 : ${dto.memberRegist }<br />
<a href="memberModify.mem?memberNum=${dto.memberNum }">수정</a> |
<a href="memberDelete.mem?memberNum=${dto.memberNum }">삭제</a> |
<a href="memberList.mem">리스트이동</a>
</body>
</html>