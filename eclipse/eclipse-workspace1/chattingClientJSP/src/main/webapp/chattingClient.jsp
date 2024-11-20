<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
function connect() {
   ws = new WebSocket("ws://172.16.105.87:1234");
   ws.onopen = onOpen;
   ws.onmessage = onMessage;
   ws.onclose = onClose;
}
function appendMessage(msg){
   $("#chatMessageArea").append(msg + "<br />");
   var chatAreaHeight = $("#chatArea").height();
   var maxScroll = $("#chatMessageArea").height() - chatAreaHeight
   $("#chatArea").scrollTop(maxScroll);
}
function onOpen(evt){
   appendMessage("연결되었습니다.");
}
function onMessage(evt){
   var data = evt.data;
   appendMessage(data);
   
}
function onClose(evt){
   appendMessage("연결을 끊었습니다.");
}
function send(){
   var msg = $("#message").val();
   ws.send(msg);
   $("#message").val("");
}
function  disconnect(){
   ws.close();
}
$(function(){
   $("#enterBtn").click(function(){connect();});
   $("#exitBtn").click(function(){disconnect();});
   $("#sendBtn").click(function(){send();});
});
</script>
</head>
<body>
<input type="button" id="enterBtn" value="입장" />
<input type="button" id="exitBtn" value="나가기" />
<h1>대화영역</h1>
<div id="chatArea">
   <div id="chatMessageArea"></div>
</div>
<input type="text" id="message" placeholder="Enter your message..." />
<button id="sendBtn">전송</button>
</body>
</html>