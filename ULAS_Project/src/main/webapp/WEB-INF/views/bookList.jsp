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
</head>
<body>
	<table class="table table-hover">
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
			<td>${list.bookcode}</td>
			<td><a href="./bookDetail.do">${list.title}</a></td>
			<td>${list.author}</td>
			<td>${list.publish.publisher}</td>
		</tr>
</c:forEach>
	</table>
</body>
</html>