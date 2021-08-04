package com.las.khj.dto;

import java.io.Serializable;
import java.util.Date;

public class Search_Dto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5359194474485641565L;
	private String bookcode;
	private String title;
	private String author;
	private String publisher;
	private String classname;
	public Search_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Search_Dto(String bookcode, String title, String author, String publisher, String classname) {
		super();
		this.bookcode = bookcode;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.classname = classname;
	}
	@Override
	public String toString() {
		return "Search_Dto [bookcode=" + bookcode + ", title=" + title + ", author=" + author + ", publisher="
				+ publisher + ", classname=" + classname + "]";
	}
	public String getBookcode() {
		return bookcode;
	}
	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
