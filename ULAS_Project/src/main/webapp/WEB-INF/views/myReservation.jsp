<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8;");
%>

<%@include file="/header.jsp"%>

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


<div class="container">
		<h2>나의 예약 현황</h2>
		<p>회원님께서 예약하신 도서 목록입니다.</p>
		<table class="table">
			<thead>
				<tr>
					<td>No.</td>
					<th>도서명</th>
					<th>예약순번</th>
					<th>예약취소</th>
					
				</tr>
			</thead>
			


			<tbody>
			<c:forEach var="j" items="${lists}" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>${j.title}</td>
					<td>${j.step}</td>
					<td>
					<form action="./cancleReserve.do" method="post" >
						<input type="hidden" name="seq" id="seq" value="${j.seq }">
						<input type="submit" value="예약취소">
					</form>
					</td>
				</tr>
			</c:forEach>	
			</tbody>
		</table>
	</div>

<input type="button" value="돌아가기" onclick="javascript:history.back(-1)">

</body>
</html>