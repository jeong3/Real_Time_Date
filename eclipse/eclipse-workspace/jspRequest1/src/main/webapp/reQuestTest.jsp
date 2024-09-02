<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "requestParam.jsp" method="get">
	아이디 : <input type="text" name="userId"/><br />
	관심분야 :
	<input type="checkbox" name="cp" value="엔터테인먼트" />엔터테인먼트
	<input type="checkbox" name="cp" value="컴퓨터/인터넷" />컴퓨터/인터넷
	<input type="checkbox" name="cp" value="경제/비즈니스" />경제/비즈니스
	<input type="checkbox" name="cp" value="스포츠/건강" />스포츠/건강
	<input type="checkbox" name="cp" value="여행/관광" />여행/관광<br />
	<input type = "submit" value = "전송" />
	
	</form>
</body>
</html>