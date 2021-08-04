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
function registChk() {
	var email = document.getElementById("email");
	var pw1 = document.getElementById("password");
	var pw2 = document.getElementById("passOk");
	var name = document.getElementById("name");
	var address = document.getElementById("address");
	var phone = document.getElementById("phone");
	
	if (pw1.value != pw2.value) {
		alert("입력한 비밀번호가 틀립니다. 다시 확인 해 주세요");
		pw2.value="";
		pw2.focus();
	} else {
		$.ajax({
			type:"post",
			url:"./regist.do",
			data:"email="+email.value+"&password="+pw1.value+"&name="+name.value+"&address="+address.value+"&phone="+phone.value,
			success:function(msg){
				if(msg.isc == "성공") {
					alert("회원가입에 성공하였습니다.\n이제부터 로그인이 가능합니다.");
					location.href="./loginForm.do";
				} else {
					alert("회원가입에 실패하였습니다.");
				}
			},
			error:function(){
				alert("회원가입에 문제가 있습니다.");
			}
		});
	}
}
</script>
<body>
		<div>
			<input type="text" id="email" name="email" value="${rEmail }" readonly><br>
			<input type="password" id="password" name="password" placeholder="비밀번호" required="required"><br>
			<input type="password" id="passOk" placeholder="비밀번호 확인" required="required"><br>
			<input type="text" id="name" name="name" placeholder="이름" required="required"><br>
			<input type="text" id="address" name="address" placeholder="주소" required="required"><br>
			<input type="text" id="phone" name="phone" placeholder="번호" required="required"><br>
		</div>
		<div>
			<input type="button" id="regist" name="regist" value="가입하기" onclick="registChk()">
		</div>
</body>
</html>