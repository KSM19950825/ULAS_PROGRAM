<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서검색 크롤링</title>
<script type="text/javascript">
	function detailSearch(val) {
		var frm = document.forms[val];
		frm.method="post";
		frm.action="./searchBookDetail.do";
		frm.submit();
	}
</script>
</head>
<body>
<c:forEach var="bookOne" items="${bookList}" varStatus="vs">
	<form>
		<span>${vs.count} /</span>
		<span> ${bookOne.title}</span><br>	
		<input type="hidden" name="url" value="${bookOne.content}">
		<input type="button" value="선택" onclick="detailSearch('${vs.count}')">
	</form>
</c:forEach>
</body>
</html>