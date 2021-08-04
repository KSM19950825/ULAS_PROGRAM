<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>도서명</th>
			<th>저자</th>
			<th>장르</th>
			<th>출판사</th>
		</tr>
	<c:forEach var="list" items="${listBook}" varStatus="vs">
		<tr>
			<td><a href="./bookDetail.do?bookcode=${list.bookcode}"  id="bookcode">${list.title}</a></td>
			<td>${list.author}</td>
			<td>${list.classname}</td>
			<td>${list.publisher}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>