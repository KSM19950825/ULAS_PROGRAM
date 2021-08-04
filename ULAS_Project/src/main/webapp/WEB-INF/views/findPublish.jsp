<%@page import="com.las.khj.dto.BookInfo_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출판사 조회</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
function chkPubl() {
	var publ = document.getElementById("publisher").value;
	console.log(publ);
	$.ajax({
		url : "./searchPublish.do", // Controller에서 이 주소를 가지는  메소드에서 검색 결과 출력하기
		method : "post",
		method : "post",
		data : "publisher=" + publ,
		dataType : "JSON",
		async : true,
		succeess : function () {
			
		},
		error : function () {
			alert("잘못된 요청입니다.");
		}
	});

	}
//	if(publ != "") {
//	$.ajax({

//	});
// }
</script>
</head>
<body>
<div>
	<form id ="frm" method="post" onsubmit="chkPubl()">
		<input type="text" name="publisher" id="publisher">
		<span id="msg"></span>
		<input type="button" value="조회">
	</form>
</div>
<div id="condition"></div>
</body>
</html>