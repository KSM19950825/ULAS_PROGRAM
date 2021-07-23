package com.las.khj.dto;

import java.util.Date;

public class BookInfo_Dto {

	private String bookcode;
	private String title;
	private String author;
	private String publcode;
	private String calsscode;
	private Date publishing;
	private String content;
	private String qr;
	private String img;
	private int cnt;
	
	public BookInfo_Dto() {
	}

	public BookInfo_Dto(String bookcode, String title, String author, String publcode, String calsscode,
			Date publishing, String content, String qr, String img, int cnt) {
		super();
		this.bookcode = bookcode;
		this.title = title;
		this.author = author;
		this.publcode = publcode;
		this.calsscode = calsscode;
		this.publishing = publishing;
		this.content = content;
		this.qr = qr;
		this.img = img;
		this.cnt = cnt;
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

	public String getPublcode() {
		return publcode;
	}

	public void setPublcode(String publcode) {
		this.publcode = publcode;
	}

	public String getCalsscode() {
		return calsscode;
	}

	public void setCalsscode(String calsscode) {
		this.calsscode = calsscode;
	}

	public Date getPublishing() {
		return publishing;
	}

	public void setPublishing(Date publishing) {
		this.publishing = publishing;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getQr() {
		return qr;
	}

	public void setQr(String qr) {
		this.qr = qr;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "BookInfo_Dto [bookcode=" + bookcode + ", title=" + title + ", author=" + author + ", publcode="
				+ publcode + ", calsscode=" + calsscode + ", publishing=" + publishing + ", content=" + content
				+ ", qr=" + qr + ", img=" + img + ", cnt=" + cnt + "]";
	}
}
