<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	형변환 <br />
	<%= (char)65 %><br />
	<%= (int)'A' %><br />
	<%
	int i = 10;
	out.print(i + "<br />");
	long l = 210000000;
	l = 21000000000L;
	out.print(l+"<br />");
	float f = 0.5f;
	out.print(f+"<br />");
	double d = 0.5;
	out.print(d+"<br />");
	boolean bl = true;
	out.print (bl+"<br />");
	String str = "10";
	String str1 = "20";
	out.print(Integer.parseInt(str) + Integer.parseInt(str1)+"<br />");
	Integer i1 = 10; //boxing
	i = i1; //unboxing
	
	//배열
	int [] arrayInt = new int[3];
	arrayInt[0] = 10;
	arrayInt[1] = 20;
	arrayInt[2] = 30;
	for(int val : arrayInt){
		out.print(val+" ");
	}

	%><br />
	<table border="1">
	<%
	
	int tr = 1;
	while(tr <= 9){
		out.print("<tr>");
		int td = 1;
		while(td <= 9){
			out.print("<td>"+td+"</td>");
			td++;
		}
		out.print("</tr>");
		tr++;
	}
	%>
	</table>
	<%
	int num = 12 / 3;
	switch(num){
	case 1 : out.print("1"); break;
	case 2 : out.print("2"); break;
	case 3 : out.print("3"); break;
	case 4 : out.print("4"); break;
	default : out.print("해당 숫자 없음");
	}

	%> <br />
	문자열 메서드
	<%
		String str2 = "first string";
		String str3 = "second string";
	%>
	str2 = <%= str2 %><br />
	ing의 index를 출력 : <%= str2.indexOf("ing") %><br />
	'a'의 index를 출력 : <%= str2.indexOf('a') %><br /> <!--  -1을 출력 -->
	index 3이후에 있는 's'의 index : <%= str2.indexOf('s',3) %><br />
	두번째 's'의 index는 : <%= str2.indexOf('s',str2.indexOf('s')+1) %><br />
	str2의 글자의 개수 : <%= str2.length() %><br />
	4번째 index에 있는 문자 : <%=str2.charAt(4) %><br />
	6번 index부터 3글자 : <%= str2.substring(6,9) %><br />
	6번부터 끝까지 : <%= str2.substring(6) %>
</body>
</html>