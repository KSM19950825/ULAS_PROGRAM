<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SelectTest</title>
</head>
<body>
<div>
	<fieldset>
		<legend>세션정보</legend>
		<p>
			성명 : ${sessionUser.name}<br>
			이메일/ID : ${sessionUser.email}<br>
			권한 : ${sessionUser.auth }<br>
		</p>
	</fieldset>

</div>
	<c:forEach var="j" items="${lists}">
		<div>${j}</div>
	
	
	</c:forEach>

</body>
</html>