package com.las.khj.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.las.khj.dto.BookInfo_Dto;

@Repository
public class IBookDaoImpl implements IBookDao {
	
	@Autowired
	private SqlSessionTemplate sqlsession;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private String NS = "com.las.khj.model.dao.IBookDao.";

	@Override
	public boolean insertBooks(BookInfo_Dto bookDto) {
		log.info("IBookDaoImpl 도서등록 : {}", bookDto);
		
		System.out.println(bookDto.getTitle());
		System.out.println(bookDto.getAuthor());
		System.out.println(bookDto.getPublcode());
		System.out.println(bookDto.getClasscode());
		System.out.println(bookDto.getPublishing());
		System.out.println(bookDto.getContent());
		System.out.println(bookDto.getChapter());
		System.out.println(bookDto.getImg());
		
		int book = sqlsession.insert(NS+"insertBooks", bookDto);
		return (book>0)?true:false;
	}

	@Override
	public int countBooks(String bookcode) {
		log.info("IBookDaoImpl 같은 BookCode의 권수 : {}", bookcode);
		return sqlsession.selectOne(NS+"countBooks", bookcode);
	}

	@Override
	public boolean insertLocation(BookInfo_Dto bookDto) {
		log.info("IBookDaoImpl 도서 위치입력 : {}", bookDto);
		int loc = 0;
		String inLoc = bookDto.getLoc(); // 008차
		for (int i = 0; i < bookDto.getCnt(); i++) {
			loc += sqlsession.insert(NS+"insertLocation", bookDto);
			bookDto.setLoc(inLoc);
		}
		return (loc>0)?true:false;
	}

	@Override
	public List<BookInfo_Dto> bookList() {
		log.info("IBookDaoImpl 등록된 도서 전체리스트 조회");
		return sqlsession.selectList(NS+"bookList");
	}

//	@Override
//	public BookInfo_Dto detailBook(String bookcode) {
//		log.info("IBookDaoImple 도서 상세정보 조회 : {}", bookcode);
//		BookInfo_Dto bookDto = sqlsession.selectOne(NS+"detailBook", bookcode);
//		return bookDto;
//	}


}
