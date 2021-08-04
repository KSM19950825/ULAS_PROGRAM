<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./findBook.do" method="get">
	<table>
		<tr>
			<th>제목 : </th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>작가 : </th>
			<td><input type="text" name="author"></td>
		</tr>
		<tr>
			<th>장르 : </th>
			<td><input type="text" name="classname"></td>
		</tr>
		<tr>
			<th>출판사 : </th>
			<td><input type="text" name="publisher"></td>
		</tr>
	</table>
	<input type="submit" value="검색">
</form>
</body>
</html>