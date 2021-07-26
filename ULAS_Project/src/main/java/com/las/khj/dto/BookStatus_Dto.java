package com.las.khj.dto;

import java.io.Serializable;

public class BookStatus_Dto implements Serializable{

	private static final long serialVersionUID = -7602394514344150616L;
	
	private int bookseq;
	private String bookcode;
	private String reserve;
	private String statuscode;
	private String location;
	
	public int getBookseq() {
		return bookseq;
	}
	public void setBookseq(int bookseq) {
		this.bookseq = bookseq;
	}
	public String getBookcode() {
		return bookcode;
	}
	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	public String getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "BookStatus_Dto [bookseq=" + bookseq + ", bookcode=" + bookcode + ", reserve=" + reserve
				+ ", statuscode=" + statuscode + ", location=" + location + "]";
	}
	
	

}
