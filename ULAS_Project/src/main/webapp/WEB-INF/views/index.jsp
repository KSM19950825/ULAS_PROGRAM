<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>





<div class="body-wrap wrapper container" >
	<div>
	<!--메인 이미지 주기능 리스트 -->
		<div class="main_list" style="text-align: center">
			<div class="list_start">
				<div class="list_pair">
					<div class="list_detail">
						<a class="service01" href="./bookList.do"><span>도서목록</span></a>
					</div>
					<div class="list_detail">
						<a class="service02" href=""><span>대출기록</span></a>
					</div>
				</div>
				<div class="list_pair">
					<div  class="list_detail">
						<a class="service03" href=""><span>예약현황</span></a>
					</div>
					<div class="list_detail">
						<a class="service04" href=""><span>도서신청</span></a>
					</div>
				</div>
			</div>
			
		</div>

	


		<div class="searchBarWrap"   >
			<hr>
			<div class="searchBar"  >
				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="검색할 도서정보를 입력해주세요"
						aria-label="Search">
					<button class="searchBtn btn btn-outline-success" type="submit">검색</button>
				</form>
			</div>
		</div>








	</div>
</div>



<%@include file="/footer.jsp"%>
