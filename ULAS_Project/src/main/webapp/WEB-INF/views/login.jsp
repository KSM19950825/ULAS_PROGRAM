<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<script type="text/javascript">
	function loginCheck() {
		var email = document.getElementById("inputId");
		var password = document.getElementById("inputPw");
		
		console.log(email.value, password.value);
		
		var frm = document.forms[0];
		frm.action = "./login.do";
		console.log(frm);
		
		if(email.value == "" || email.value.trim() == "") {
			alert("아이디를 입력 해 주세요");
			email.value="";
			email.focus();
		} else if(password.value == "" || password.value.trim() == "") {
			alert("비밀번호를 입력 해 주세요");
			password.value="";
			password.focus();
		} else {
			$.ajax({
				type:"post",
				url:"./loginCheckMap.do",
				data:"email="+email.value+"&password="+password.value,
				success:function(msg){
					console.log(msg.isc);
					if(msg.isc == "성공") {
						console.log(msg.isc);
						frm.submit();
					} else {
						alert("아이디 또는 비밀번호를 확인하십시오.");
					}
				},
				error:function(){
					alert("로그인에 문제가 있습니다.");
				}
			});
		}
	}
</script>
</head>
<body>
<div id="container">
	<div id="title">Total Spring</div>
	<form method="post">
		<div class="inputWord">아이디</div>
		<input type="text" name="email" id="inputId" placeholder="아이디 입력"><br>
		<div class="inputWord">비밀번호</div>
		<input type="password" name="password" id="inputPw" placeholder="비밀번호 입력" onkeyup="enterKey()"><br>
		<div style="text-align: center;">
			<input type="button" id="login" name="login" value="LOGIN" onclick="loginCheck()">
		</div>
		<div id="bottom">
			<input type="button" id="registForm" value="회원가입">
			<input type="button" value="아이디찾기">
			<input type="button" value="비밀번호찾기">
		</div>
	</form>
</div>
<script type="text/javascript">
	function enterKey() {
		if(window.event.keyCode == 13) {
			loginCheck();
		}
	}
	window.onload = function() {
		document.getElementById("registForm").onclick = function() {
			console.log("회원가입");
			location.href="./registForm.do";
		}
	}
</script>
</html>