<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>크롤링 상세검색</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<style type="text/css">
li{
	list-style: none;
}
</style>
<script type="text/javascript">

function findPublishs() {
// 	var publ = document.getElementById("chkPubl").value;
// 	console.log(publ);
	var url = "./findPublish.do"
	var title = "출판사 조회";
	var prop = "top=200px, left=400px,  width=450px, height=250px, scrollbars=no, resizeable=no";
	window.open(url, title, prop);
}

// var chkLoc = 'n';

	function modifyValue() {
		var chapter = document.getElementById("chapter");
		var chap = document.getElementById("chp");
		var chapterConvert = chapter.value.replaceAll('\n','<br>');
// 		chap.innerHTML = chapterConvert;
		var loc = document.getElementById("loc");
		console.log(loc.value);
		if(loc.value == "") {
			alert('위치를 입력해주세요');
			return false;
		}
		chapter.value = chapterConvert;
		
		
// 		else if(chkLoc == "n"){
// 			alert('위치를 중복검사를 해주세요');
// 		}
	}
	
	//Ajax 
// 	function checkLoc(){
// 		document.getElementByIdj.("loc").readOnly="readOnly";
// 		document.getElementById("loc").style.background="gray";
// 	}
	
	
</script>
</head>
<body>
<form action="./insertBook.do" method="post" onsubmit="return modifyValue()">
	<div>
		<div>
			<span>
				<input name="img" type="hidden" value="${searchDetail.img}">
				<img alt="도서이미지" src="${searchDetail.img}">
			</span>
		</div>
		<div>
			<ul>
				<li><input type="hidden" name="bookcode" value="${searchDetail.bookcode}"></li>
				<li>도서명 : <input type="text" name="title" value="${searchDetail.title}"></li>
				<li>저자 : <input type="text" name="author" value="${searchDetail.author}"></li>
				<li>
					출판사 : <input type="text" name="publcode" id="publcode" value="${searchDetail.publcode}">
<!-- 					<input  type="button" value="출판사 조회" onclick="javascript:location.href='./findPublish.do'"> -->
					<input type="button" value="출판사 조회" id="chkPubl" onclick="findPublishs()">
				</li>
				<li>발행일 : <input type="text" name="publishing" value="${searchDetail.publishing}"></li>
				<li>장르 : 
					<select name="classcode"> 
						<option value="CLASS000">기타</option>
						<option value="CLASS001">철학</option>
						<option value="CLASS002">종교</option>
						<option value="CLASS003">사회과학</option>
						<option value="CLASS004">순수과학</option>
						<option value="CLASS005">기술과학</option>
						<option value="CLASS006">예술</option>
						<option value="CLASS007">언어</option>
						<option value="CLASS008">문학</option>
						<option value="CLASS009">역사</option>
					</select>
				</li>
				<li>
					위치 : <input type="text" name="loc" id="loc">
					<input type="button" value="위치확인" onclick="checkLoc()"> 
					</li>
				
				<li><br>
					책소개<br>
					<textarea name="content" rows="10" cols="50" id="content">${searchDetail.content}</textarea>
				</li>
				<li>
					목차<br>
					<textarea name="chapter" rows="10" cols="100" id="chapter">${searchDetail.chapter}</textarea>
<!-- 					<input type="button" value="확인" onclick="chap()"> -->
				</li>
			</ul>
		</div>
		<div>
			<input type="number" name="cnt" min="1" max="4" value="1">
			<input type="submit" value="저장">
		</div>
		
	</div>
</form>
<div id="chp"></div>
</body>
</html>