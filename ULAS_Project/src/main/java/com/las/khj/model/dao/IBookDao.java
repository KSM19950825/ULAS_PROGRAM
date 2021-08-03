package com.las.khj.model.dao;

import java.util.List;
import java.util.Map;

import com.las.khj.dto.BookInfo_Dto;

public interface IBookDao {

	public boolean insertBooks(BookInfo_Dto bookDto); // 도서등록
	
	public int countBooks(String bookcode); // 최대 권수 카운트
	
	public boolean insertLocation(BookInfo_Dto bookDto); // 위치등록
	
	public List<BookInfo_Dto> bookList(); // 등록된 도서 전체리스트
	
	public BookInfo_Dto detailInfo(String bookcode); // DB에 저장된 도서 상세조회(도서 1권의 정보)
	
	public BookInfo_Dto searchPublish(String publisher); // 출판사 검색
	
	public boolean insertPublish(Map<String, Object>publMap); // 검색된 결과에 해당 출판사가 없을 경우 등록
	
}
