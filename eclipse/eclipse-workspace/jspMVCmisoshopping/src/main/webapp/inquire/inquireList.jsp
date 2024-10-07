<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#inquire1").click(
				function() {
					window.open("inquireWrite.inq?goodsNum=${goodsNum}",
							"문의하기",
							"width=700 , height=650 , top=100, left=100");
				});
	});
	function inquireUpdate(inquireNum) {
		window.open("inquireUpdate.inq?inquireNum=" + inquireNum, "문의하기",
				"width=700 , height=650 , top=100, left=100");
	}
	function inquireDelete(inquireNum) {
		$.ajax({
			type : "post",
			url : "inquireDelete.inq",
			data : {
				"inquireNum" : inquireNum
			},
			success : function() {
				inquire();
			},
			error : function() {
				alert("에러발생");
				return;
			}
		});
	}
	function answerOpen(inquireNum){
		if($("#Ans"+inquireNum).text() == '답변열기' ){
			$("#Ans"+inquireNum).text('답변닫기');
			$("#Inq"+inquireNum).css("display","");
		}else{
			$("#Ans"+inquireNum).text('답변열기');
			$("#Inq"+inquireNum).css("display","none");
		}
	}
</script>
</head>
<body>
	<table width="800" align="center" border="1">
		<tr>
			<td colspan="3" align="right">
				<button type="button" id="inquire1">문의하기</button>
			</td>
		</tr>
		<tr>
			<th width="15%">답변상태</th>
			<th>작성자</th>
			<th>질문일자</th>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<th width="15%">
				<c:if test="${empty dto.inquireAnswer }">
				검토중
				</c:if>
				<c:if test="${!empty dto.inquireAnswer }">
				답변
				</c:if>
				</th>
				<th>${dto.memberNum }</th>
				<th>${dto.inquireDate }</th>
			</tr>
			
			<tr>
				<td colspan="3" align="left">${dto.inquireKind }
					:${dto.inquireSubject } <c:if test="${memberNum == dto.memberNum }">
						<span style="float: right"><button
								onclick="inquireUpdate('${dto.inquireNum}');">수정</button>
							<button onclick="inquireDelete('${dto.inquireNum}');">삭제</button></span>
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="3">${fn:replace (dto.inquireContent, newLine, "<br />") }
				<c:if test="${!empty dto.inquireAnswer }">
				<button type="button" style="float:right;" id="Ans${dto.inquireNum }" onclick="answerOpen('${dto.inquireNum}')">답변열기</button>
				</c:if>
				</td>
			</tr>
			
			<c:if test="${!empty dto.inquireAnswer }">
				<tr style="display:none;" id="Inq${dto.inquireNum }">
					<td>답변</td>
					<td colspan="2">${dto.inquireAnswer }</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>