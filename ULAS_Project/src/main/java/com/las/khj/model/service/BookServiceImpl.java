package com.las.khj.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.las.khj.dto.BookInfo_Dto;
import com.las.khj.model.dao.IBookDao;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookDao bookDao;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean insertBooks(BookInfo_Dto insertDto) {
		log.info("IBookServiceImpl 도서등록 : {}", insertDto);
		boolean book = bookDao.insertBooks(insertDto);  //  ture성공
		int count = bookDao.countBooks(insertDto.getBookcode()); /// 없을 수 있고
		System.out.println(count); // 
		System.out.println(insertDto.getBookcode()+"-----------------------");
		if(insertDto.getCnt()-count > 0) {  //  없을 수 있고
			insertDto.setCnt(insertDto.getCnt()-count);
//			System.out.println(insertDto.getBookcode()+"***********************");
//			System.out.println(insertDto.getLoc()+"***********************");
			boolean loc = bookDao.insertLocation(insertDto);
		}
		return book ; 
	}

	@Override
	public List<BookInfo_Dto> bookList() {
		log.info("IBookServiceImpl 등록된 도서 전체리스트 조회");
		return bookDao.bookList();
	}

	@Override
	public BookInfo_Dto detailInfo(String bookcode) {
		log.info("IBookServiceImpl 등록된 도서 상세조회 : {}", bookcode);
		return  bookDao.detailInfo(bookcode);
	}
	
	@Override
	public BookInfo_Dto searchPublish(String publisher) {
		log.info("IBookDaoImple 출판사 조회 : {}", publisher);
		return bookDao.searchPublish(publisher);
	}

	@Override
	public boolean insertPublish(Map<String, Object> publMap) {
		log.info("IBookDaoImple 출판사 등록 : {}", publMap);
		return bookDao.insertPublish(publMap);
	}
}
