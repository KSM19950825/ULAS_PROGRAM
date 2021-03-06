<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8;");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet">
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	
	<link href="./css/LAS.css" rel="stylesheet">
	<title>:: [U L A S] LAS SYSTEM ::</title>
</head>
<body>
	<section>
	<div class="headerWrap">
		<div class="logoinfoWrap">
		<div class="logoinfo">
			<div class="headerlogo">
				<a href="./main.do"><img src="images/logo/logo.png" alt="" ></a>
				<span>가산 마을도서관</span>
			</div>
			<div class="headerinfo">
				<ul>
					<li class="btn-home"><a  href="./main.do">홈</a></li>
					<li><a id="goto-login" class="ulas-log" href="./loginForm.do">로그인</a></li>
					<li><a href="./registForm.do">회원가입</a></li>
				</ul>
			</div>
		</div>
		</div>
		<!-- navbar -->
		<nav class="navbar navbar-expand-lg  " ><!-- navbar-light bg-light -->
			<div class="container-fluid" >
				<a class="navbar-brand" href="./main.do">U L A S</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
					aria-controls="navbarNavDropdown" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavDropdown">
					<ul class="navbar-nav" style="margin: auto;">
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="./main.do">Home</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="./findBookForm.do">도서 상세 검색</a>
						</li>
						<li class="nav-item">
						<a class="nav-link" href="./searchBook.do">도서 등록</a>
						</li>
						<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">나만의 도서관</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
								<li><a class="dropdown-item" href="./myRent.do">나의 대출 기록</a></li>
								<li><a class="dropdown-item" href="./myReservation.do">나의 예약 현황</a></li>
								<!-- <li><a class="dropdown-item" href="#">Something else here</a></li> -->
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>	