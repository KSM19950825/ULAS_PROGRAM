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
	<form action="regist.do" method="post">
		<input type="text" name="email" id="email" placeholder="이메일 입력">
		<input type="button" id="emailChk" name="emailChk" value="이메일확인" onclick="emailCheck()"><br>
		<input type="text" name="otp" id="otp" placeholder="인증번호 입력">
	</form>
</body>
<script type="text/javascript">
function emailCheck() {
	var email = document.getElementById("email");
	
	console.log(email.value);
	
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
				console.log(msg.isc);
				if(msg.isc == "성공") {
					console.log(msg.isc);
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
</script>
</html>