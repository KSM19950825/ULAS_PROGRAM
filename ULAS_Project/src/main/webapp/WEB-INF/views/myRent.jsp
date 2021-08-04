<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8;");
%>

<%@include file="/header.jsp"%>

	<c:forEach var="j" items="${lists}" varStatus="i">
		<div>${j}</div>
	</c:forEach>

	<div class="container">
		<h2>나의 대출 현황</h2>
		<p>회원님께서 현재 대출 중인 도서 목록입니다.</p>
		<table class="table">
			<thead>
				<tr>
					<td>No.</td>
					<th>도서명</th>
					<th>대여일시</th>
					<th>반납일시</th>
					
				</tr>
			</thead>
			


			<tbody>
			<c:forEach var="j" items="${lists}" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>${j.title}</td>
					<td>${j.start_date}</td>
					<td>${j.return_date}
					<c:if test = "${j.return_date eq null}">
						<form action="./returnBook.do" method="post" >
							<input type="hidden" name="seq" id="seq" value="${j.seq}">
							<input type="submit" value="반납">
						</form>
					</c:if>
					</td>
				</tr>
			</c:forEach>	
			</tbody>
		</table>
	</div>

<input type="button" value="돌아가기" onclick="javascript:history.back(-1)">

</body>
</html>