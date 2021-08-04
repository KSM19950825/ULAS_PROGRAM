<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세정보</title>
<style type="text/css">
li{
	list-style: none;
}
#container{
	width: 800px;
	display: flex;
}
</style>
</head>
<body>
<section>
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
			${detailBook.content}
		<li>
			목차<br>
			${detailBook.chapter}
		</li>
	</ul>
</div>
<div>
	<table>
		<tr>
			<th>NO.</th>
			<th>BookSeq</th>
			<th>도서명</th>
			<th>대출상태</th>
			<th>도서상태</th>
			<th>위치</th>
		</tr>
		<c:forEach var="bookStatusList" items="${detailBook.bookstatus}" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${bookStatusList.bookseq}</td>
			<td>${detailBook.title}</td>
			<td>${bookStatusList.statuscode}</td>
			<td>${detailBook.status}</td>
			<td>${bookStatusList.loc}</td>
		</tr>
		</c:forEach>
		<tr>
			<td>
				<a href="./bookModify.do" >
					<input type="button" value="도서수정">
				</a>
			</td>
		</tr>
	</table>	
</div>
</section>
</body>
</html>