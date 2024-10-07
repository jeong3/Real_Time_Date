<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardModify.com" method="post" >
번호 : <input type="text"  name="boardNum" value="${dto.boardNum }" readonly="readonly" /> <br/>
작성자 : <input type="text"  name="boardWriter" value="${dto.boardWriter }"/> <br/>
제목 :<input type="text"  name="boardSubject" value="${dto.boardSubject }"/> <br/>
내용 : <textarea rows="5" cols="60" name="boardContent">${dto.boardContent }</textarea>
<input type="submit" value="수정" />
</form>
</body>
</html>