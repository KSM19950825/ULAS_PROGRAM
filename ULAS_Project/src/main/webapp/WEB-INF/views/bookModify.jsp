<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서수정</title>
<style type="text/css">
li{
	list-style: none;
}
#container{
	width: 800px;
	display: flex;
}
</style>
<script type="text/javascript">
	function chkStatus() {
		
	}

</script>
</head>
<body>
<section>
<fieldset>
	<legend>도서상태 정보 수정</legend>
	<form action="./modifyStatus.do" onsubmit="chkStatus()">
		<table>
			<tr>
				<th>도서고유번호</th>
				<th>BookCode</th>
				<th>도서명</th>		
				<th>도서상태</th> 
				<th>위치</th>
			</tr>
			<c:forEach var="m" items="${modify}">
				<tr>
					<td>${m.bookseq}</td>
					<td>${m.bookcode}</td>
					<td></td>
					<td>
						<select name="classcode">
							<option value="S001">정상</option>
							<option value="S002">훼손</option>
							<option value="S003">폐기</option>
						</select>
					</td>
					<td><input type="text" name="loc"></td>
					<td><input type="submit" value="변경"></td>
				</tr>
			</c:forEach>
		</table>
		
	</form>
</fieldset>
<!-- 같은 BOOKCODE의 리스트를 위로 옮기고 거기서 바꾸는 건가? -->
<div id="container">
	<div id="bookImg">
		<img alt="도서이미지" src="${detailBook.img}">
	</div>
	<div id="bookInfo">
		<ul>
			<li>도서명 : ${detailBook.title}</li>
			<li>저자 : ${detailBook.author}</li>
			<li>출판사 : ${detailBook.publish.publisher}</li>
			<li>발행일 : ${detailBook.publishing}</li>
			<li>장르 : ${detailBook.classcode}</li>
			<li>위치 : ${detailBook.loc}</li>
		</ul>
		<span>
			<input  type="button" value="대출/예약">
		</span>
	</div>
</div>
<div>
	<ul>
		<li>
			책소개<br>
			
		<li>
			목차<br>
			
		</li>
	</ul>
</div>
<div>
	<table>
		<tr>
			<th>NO.</th>
			<th>BookCode</th>
			<th>도서명</th>
			<th>대출상태</th>
			<th>도서상태</th>
			<th>위치</th>
		</tr>
		<c:forEach var="bookStatusList" items="${modifyBook}" varStatus="vs">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		</c:forEach>
		<tr>
			<td>
				<input type="button" value="수정완료"  onclick="checkBook()">
			</td>
		</tr>
	</table>	
</div>
</section>
</body>
</html>