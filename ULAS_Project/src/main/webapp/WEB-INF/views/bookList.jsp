<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록된 도서 전체조회</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function chk() {
		var book = document.getElementById("bookcode").value;
		console.log(book);
	}
</script>
<style type="text/css">
#table{
	width: 1050px;
}
</style>
</head>
<body>
	<table class="table table-hover" id="table">
		<tr>
			<th>NO.</th>
			<th>도서코드</th>
			<th>도서명</th>
			<th>저자</th>
			<th>출판사</th>
		</tr>
<c:forEach var="list" items="${listBook}" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td><a href="./bookDetail.do" onclick="chk()" id="bookcode">${list.bookcode}</a></td>
			<td>${list.title}</td>
			<td>${list.author}</td>
			<td>${list.publish.publisher}</td>
		</tr>
</c:forEach>
	</table>
	<input type="button" value="돌아가기" onclick="javascript:history.back(-1)">
</body>
</html>