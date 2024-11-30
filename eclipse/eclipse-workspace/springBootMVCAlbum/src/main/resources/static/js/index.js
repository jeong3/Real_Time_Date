/**
 * 
 */
$(function(){
	memEmpInfo();	
	memberList();
	empList();
	myInfo();
	
});
// Accordion 
function myAccFunc() {
  var x = document.getElementById("demoAcc");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else {
    x.className = x.className.replace(" w3-show", "");
  }
}



// Open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}

function searchGoods(element) {
    const searchWord = $("#searchWord").val(); // 입력된 검색어 가져오기
	var category = null;
	if (element instanceof HTMLElement) category = $(element).data('category');
	alert(category);
    $.ajax({
        type: "POST",
        url: "/",
        data: { "searchWord": searchWord , "category": category}, // 데이터 객체로 전송
        dataType: "html",
        success: function(result) {
            alert(result);
			 $("#searchResult").html(result);
        },
        error: function() {
            alert("검색에 실패했습니다. 다시 시도해주세요.");
        }
    });
}


function fileDel(btn, orgFile, storeFile, kind){
	
	$.ajax({
		type : "post",
		url : "/file/fileDel",
		data : {"orgFile": orgFile, "storeFile" : storeFile},
		dataType : "text",
		success : function(result){
			if(result == 1){
				$(btn).html("<span class='w3-bar-item w3-button w3-white w3-xlarge w3-right'>⤾</span>");
				if(kind == 'main'){
					$("#main").css("display","none");
					$("#mainFile").html("<input type='file' name='goodsMainImage'/>")
				}
			}else{
				$(btn).html("<span class='w3-bar-item w3-button w3-white w3-xlarge w3-right'>×</span>");
				if(kind == 'main'){
					$("#main").css("display","");
					$("#mainFile").css("display","none");
				}
			}
			
		},
		error : function(){
			alert("서버오류");
		}
	});
}


function fileChk(){
	let fileInput = $("input[name = 'goodsMainImage']");
	if(fileInput.length > 0 && !fileInput[0].files.length){
		alert("파일 선택해주세요");
		return false;
	}
}
function goodsUpdateSubmit(element){
	var goodsNum = $(element).data('goodsNum');
	$.ajax({
		type:"post",
		url:"/goods/goodsUpdate",
		dataType:"html",
		success:function(result){
			
		},
		error:function(){
			alert("서버오류");
		}
	});
}

function goodsDelete(element){
	if (confirm("정말 삭제하시겠습니까?")) {
	var goodsNum = $(element).data('goodsNum');
		$.ajax({
			type:"get",
			url:"/goods/goodsDelete",
			data:{"goodsNum":goodsNum},
			dataType:"html",
			success:function(result){
				
				
			},
			error:function(){
				alert("서버오류");
			}
		});
	}
}
function goodsUpdate(element){
	var goodsNum = $(element).data('goodsNum');
	$.ajax({
		type:"get",
		url:"/goods/goodsUpdate",
		data:{"goodsNum":goodsNum},
		dataType:"html",
		success:function(result){
			$("#content").html(result);
		},
		error:function(){
			alert("서버오류");
		}
	});
}
function goodsDetail(element){
	var goodsNum = null;
	
	goodsNum = $(element).data('goodsNum');

	$.ajax({
		type:"get",
		url:"/goods/goodsDetail",
		data:{"goodsNum":goodsNum},
		dataType:"html",
		success:function(result){
			$("#content").html(result);
		},
		error:function(){
			alert("서버오류");
		}
	});
}
function goodsRegist(input){
	var category = null;

	   let categoryValue = null;

	   // 입력값 처리
	   if (typeof input === "string") {
	       // input이 문자열일 경우
	       categoryValue = input;
	   } else if (input instanceof HTMLElement) {
	       // input이 element일 경우
	       categoryValue = $(input).data('category');
	   }

	   if (!categoryValue) {
	       alert("유효하지 않은 카테고리 값입니다.");
	       return;
	   }

	   // 카테고리 매핑
	   if (categoryValue === "KPOP") {
	       category = "KP_";
	   } else if (categoryValue === "POP/ROCK") {
	       category = "P&R";
	   } else if (categoryValue === "CLASSIC") {
	       category = "CL_";
	   } else {
	       category = "LP_";
	   }
	$.ajax({
		type: "get",
		url: "/goods/goodsRegist",
		data : {"category": category},
		dataType:"html",
		success:function(result){
			$("#content").html(result);
		},
		error:function(){
			alert("서버 오류");
		}
	});
}
function goodsList(element){
	// 모든 a 태그에서 'w3-light-grey' 클래스와 아이콘을 제거
    $('#demoAcc a').removeClass('w3-light-grey').find('i').remove();

    // 클릭한 a 태그에 'w3-light-grey' 클래스를 추가하고 아이콘을 앞에 추가
    $(element).addClass('w3-light-grey');
    $(element).prepend('<i class="fa fa-caret-right w3-margin-right"></i>');

    // 클릭한 항목의 카테고리를 콘솔에 출력 (optional)
    var category = $(element).data('category');
    console.log(category);  // 예시로 콘솔에 출력
	$.ajax({
		type: "get",
		url: "/goods/goodsList",
		data:{"category":category},
		dataType:"html",
		success:function(result){
			
			$("#content").html(result);
		},
		error:function(){
			alert("상품이 존재하지 않습니다.");
		}
			
		
	});
}


function memberList(){
	$("#memberList").click(function(){
		memberList1();
	});
}
function memberList1(){
	$.ajax({
		type: "get",
		url: "/member/memberList",
		dataType:"html",
		success:function(result){
			
			$("#content").html(result);
		},
		error:function(){
			alert("서버 오류");
		}
			
		
	});
}
function myInfo(element) {
    const memberNum = element.getAttribute("data-member-num");
    if (memberNum == null) {
        return ; // memberNum이 없으면 함수 종료
    }

    // 여기서부터는 memberNum이 있을 때만 실행
    $.ajax({
        type: "get",
        url: "/member/memberDetail",
        data: {"memberNum": memberNum},
        dataType: "html",
        success: function (result) {
            $("#content").html(result); // 결과를 HTML에 삽입
        },
        error: function () {
            alert("서버 오류 디테일"); // 오류 시 알림
        }
    });
}
function empMyInfo(element){
	const empNum = element.getAttribute("data-emp-num");
    if (empNum == null) {
        return ; // empNum이 없으면 함수 종료
    }

    // 여기서부터는 empNum이 있을 때만 실행
    $.ajax({
        type: "get",
        url: "/emp/empDetail",
        data: {"empNum": empNum},
        dataType: "html",
        success: function (result) {
            $("#content").html(result); // 결과를 HTML에 삽입
        },
        error: function () {
            alert("서버 오류 디테일"); // 오류 시 알림
        }
    });
}
function memEmpInfo() { 
    $(document).on("click", "#myInfo", function() {
        $.ajax({
            type: "get",
            url: "/user/userDetail",
            dataType: "html",
            success: function (result) {
                $("#content").html(result); // 결과를 HTML에 삽입
            },
            error: function () {
                alert("로그인을 다시 해주세요"); // 오류 시 알림
            }
        });
    });
}

document.addEventListener("DOMContentLoaded", function () {
    const urlParams = new URLSearchParams(window.location.search);

    // URL에서 memberNum 또는 empNum 추출
    const memberNum = urlParams.get("memberNum");
    const empNum = urlParams.get("empNum");
    const category = urlParams.get("category");

    if (memberNum) {
        const dummyElement = document.createElement("div"); // 가짜 DOM 요소 생성
        dummyElement.setAttribute("data-member-num", memberNum); // element에 memberNum 값 추가
        myInfo(dummyElement); // myInfo 함수 호출
    }

    if (empNum) {
        const dummyElement = document.createElement("div"); // 가짜 DOM 요소 생성
        dummyElement.setAttribute("data-emp-num", empNum); // element에 empNum 값 추가
        empMyInfo(dummyElement); // empMyInfo 함수 호출
    }
    
});



function deleteMember(memberNum) {
    if (confirm("정말 삭제하시겠습니까?")) {
        $.ajax({
            type: "POST",
            url: "/member/memberDelete", // 삭제 엔드포인트
            data: { memberNum: memberNum }, // 삭제할 멤버 ID 전달
            success: function(response) {
                if (response == "success") {
                	memberList1(); // 삭제 후 리스트 갱신
                } else {
                    alert("삭제를 취소했습니다.");
                }
            },
            error: function() {
                alert("서버 오류가 발생했습니다. 삭제할 수 없습니다.");
            }
        });
    }
}
function deleteEmp(empNum) {
    if (confirm("정말 삭제하시겠습니까?")) {
        $.ajax({
            type: "POST",
            url: "/emp/empDelete", // 삭제 엔드포인트
            data: { empNum: empNum }, // 삭제할 직원 ID 전달
            success: function(response) {
                if (response == "success") {
                    empList1(); // 삭제 후 리스트 갱신
                } else {
                    alert("삭제를 취소했습니다.");
                }
            },
            error: function() {
                alert("서버 오류가 발생했습니다. 삭제할 수 없습니다.");
            }
        });
    }
}

function empList(){
	$("#empList").click(function(){
		empList1();
	});
}
function empList1(){
	$.ajax({
		type: "get",
		url: "/emp/empList",
		dataType:"html",
		success:function(result){
			$("#content").html(result);
		},
		error:function(){
			alert("서버 오류");
		}
			
		
	});
}

function memberRegist(){
	location.href="/member/memberRegist";
}

	

