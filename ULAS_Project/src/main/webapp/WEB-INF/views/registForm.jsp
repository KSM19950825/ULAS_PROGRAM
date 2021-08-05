<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<form method="post">
		<input type="text" name="email" id="email" placeholder="이메일 입력">
		<input type="button" id="emailChk" name="emailChk" value="이메일확인" onclick="emailCheck()"><br>
		<input type="text" name="otp" id="otp" placeholder="인증번호 입력"><br>
		<input type="button" id="otpChk" name="otpChk" value="인증하기" onclick="otpCheck()"><br>
	</form>
</body>
<script type="text/javascript">
function emailCheck() {
	var email = document.getElementById("email");
	
	if(email.value == "" || email.value.trim() == "") {
		alert("이메일을 입력 해 주세요");
		email.value="";
		email.focus();
	} else {
		$.ajax({
			type:"post",
			url:"./otpMake.do",
			data:"email="+email.value,
			success:function(msg){
				if(msg.isc == "성공") {
					alert("입력한 이메일로 메일을 발송했습니다 이메일을 확인 해주세요.");
				} else {
					alert("가입된 이메일입니다.");
				}
			},
			error:function(){
				alert("회원가입에 문제가 있습니다.");
			}
		});
	}
}
function otpCheck() {
	var email = document.getElementById("email");
	var otp = document.getElementById("otp");
	
	var frm = document.forms[0];
	frm.action = "./emailCheck.do";
	
	if(email.value == "" || email.value.trim() == "") {
		alert("이메일을 입력 해 주세요");
		email.value="";
		email.focus();
	} else if(otp.value == "" || otp.value.trim() == "") {
		alert("인증번호를 입력 해 주세요");
		otp.value="";
		otp.focus();
	} else {
		$.ajax({
			type:"post",
			url:"./otpCheck.do",
			data:"email="+email.value+"&otp="+otp.value,
			success:function(msg){
				if(msg.isc == "성공") {
					frm.submit();
				} else {
					alert("인증번호를 확인하십시오.");
				}
			},
			error:function(){
				alert("인증 시스템에 문제가 있습니다.");
			}
		});
	}
}
</script>
</html>