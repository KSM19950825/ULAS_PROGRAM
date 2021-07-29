package com.las.khj.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.las.khj.dto.Rent_Dto;
import com.las.khj.dto.Reservation_Dto;

@Repository
public class RentalDaoImpl implements IRentalDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.las.khj.model.dao.IRentalDao.";
	
	//	대출
	@Override
	public int rentBook(Map<String, Object> map) {
		return sqlSession.insert(NS+"rentBook", map) ;
	}
	//	반납
	@Override
	public int returnBook(Map<String, Object> map) {
		return sqlSession.update(NS+"returnBook", map);
	}
	//	예약 신청 tx1
	@Override 
	public int reserveBookInsert(Map<String, Object> map) {
		return sqlSession.insert(NS+"reserveBookInsert", map);
	}
	//	예약 신청 tx1
	@Override 
	public int reserveBookUpdate(Map<String, Object> map) {
		return sqlSession.update(NS+"reserveBookUpdate", map);
	}
	//	예약 취소 tx2
	@Override 
	public int cancleReserveDelete(Integer seq) {
		return sqlSession.delete(NS+"cancleReserveDelete", seq);
	}
	//	예약 취소 tx2
	@Override 
	public int cancleReserveUpdate(Integer seq) {
		return sqlSession.update(NS+"cancleReserveUpdate", seq);
	}
	//	나의 예약 현황
	@Override 
	public List<Reservation_Dto> myReservation(String email) {
		return  sqlSession.selectList(NS+"myReservation", email);
	}
	//	나의 대출 현황
	@Override
	public List<Rent_Dto> myRent(String email) {
		return sqlSession.selectList(NS+"myRent", email);
	}
	//	패널티
	@Override
	public int penaltyUpdate(String email) {
		return sqlSession.update(NS+"penaltyUpdate", email);
	}
	//	반납 예정일 메일링
	@Override
	public List<Rent_Dto> returnInfoEmail() {
		return sqlSession.selectList(NS+"returnInfoEmail");
	}
	//	연체 시 메일링
	@Override
	public List<Rent_Dto> penaltyEmail() {
		return sqlSession.selectList(NS+"penaltyEmail");
	}
	//	예약자 대출일 메일링
	@Override
	public List<Rent_Dto> reserveEmail() {
		return sqlSession.selectList(NS+"reserveEmail");
	}
	

}
