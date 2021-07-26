package com.las.khj.dto;

import java.io.Serializable;
import java.util.Date;

public class Rent_Dto implements Serializable{

	private static final long serialVersionUID = 512546276688975301L;
	
	private int seq        ;
	private String email      ;
	private int bookseq    ;
	private Date start_date ;
	
	public Rent_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rent_Dto(int seq, String email, int bookseq, Date start_date) {
		super();
		this.seq = seq;
		this.email = email;
		this.bookseq = bookseq;
		this.start_date = start_date;
	}

	@Override
	public String toString() {
		return "Rent_Dto [seq=" + seq + ", email=" + email + ", bookseq=" + bookseq + ", start_date=" + start_date
				+ "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBookseq() {
		return bookseq;
	}

	public void setBookseq(int bookseq) {
		this.bookseq = bookseq;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	
	
	
	
}
