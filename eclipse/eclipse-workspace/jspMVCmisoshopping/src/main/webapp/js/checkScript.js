/**
 * 
 */
$(function() {
		$("#userId").bind("click", function(){ //클릭 됐을 때
			$("#userId").val(""); // 아이디창의 값을 지운다
			window.open("idCheck.nhn","아이디검색","width=400, height=200, left=130, top=150"); // 자식창 띄우기
	});
});