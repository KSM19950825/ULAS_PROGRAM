package com.las.khj.model.service;

import java.util.List;
import java.util.Map;

import com.las.khj.dto.Rent_Dto;
import com.las.khj.dto.Reservation_Dto;

public interface IRentalService {
		
	//	대출
	public int rentBook(Map<String, Object> map) ;
	//	반납
	public int returnBook(Map<String, Object> map);
	//	예약 신청 tx
	public boolean reserveBook(Map<String, Object> map);
	//	예약 취소 tx
	public boolean cancleReserve(Integer seq );
	//	나의 예약 현황
	public List<Reservation_Dto> myReservation(String email);
	//	나의 대출 현황
	public List<Rent_Dto> myRent(String email);
	//	패널티
	public int penaltyUpdate(String email);
	//	반납 예정일 메일링
	public List<Rent_Dto> returnInfoEmail();
	//	연체 시 메일링
	public List<Rent_Dto> penaltyEmail(); 
	//	예약자 대출일 메일링
	public List<Rent_Dto> reserveEmail();

}
