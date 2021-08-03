package com.las.khj.model.service;

import java.util.List;
import java.util.Map;

import com.las.khj.dto.BookInfo_Dto;

public interface IBookService {

	public boolean insertBooks(BookInfo_Dto insertDto);
	
	public List<BookInfo_Dto> bookList();
	
	public BookInfo_Dto detailInfo(String bookcode);
	
	public BookInfo_Dto searchPublish(String publisher);
	
	public boolean insertPublish(Map<String, Object>publMap);
	
}
