package com.las.khj.dto;

import java.io.Serializable;
import java.util.List;

public class BookInfo_Dto implements Serializable{

	private static final long serialVersionUID = 4419054404991525917L;

	private String bookcode;
	private String title;
	private String author;
	private String publcode;
	private String classcode;
	private String publishing;
	private String content;
	private String qr;
	private String img;
	private String chapter;
	private int cnt;
	private String loc;
	
	private List<BookStatus_Dto> bookstatus;

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

	public String getClasscode() {
		return classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
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

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public List<BookStatus_Dto> getBookstatus() {
		return bookstatus;
	}

	public void setBookstatus(List<BookStatus_Dto> bookstatus) {
		this.bookstatus = bookstatus;
	}

	@Override
	public String toString() {
		return "BookInfo_Dto [bookcode=" + bookcode + ", title=" + title + ", author=" + author + ", publcode="
				+ publcode + ", classcode=" + classcode + ", publishing=" + publishing + ", content=" + content
				+ ", qr=" + qr + ", img=" + img + ", chapter=" + chapter + ", cnt=" + cnt + ", loc=" + loc
				+ ", bookstatus=" + bookstatus + "]";
	}
}
