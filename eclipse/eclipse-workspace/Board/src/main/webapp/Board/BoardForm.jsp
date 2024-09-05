<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
게시글 폼
<form action="boardWrite.com" method="post" >
작성자 : <input type="text" name="boardWriter" /> <br />
제목 :<input type="text" name="boardSubject" /> <br />
내용 : <textarea rows="5" cols="60" name="boardContent"></textarea><br />
<input type="submit" value="게시글 저장" >
</form>


</body>
</html>