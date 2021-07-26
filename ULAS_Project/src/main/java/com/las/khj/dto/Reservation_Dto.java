package com.las.khj.dto;

import java.io.Serializable;

public class Reservation_Dto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7900758915589122645L;
	
	private int seq      ;
	private String email    ;
	private String bookcode ;
	private int step     ;
	public Reservation_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation_Dto(int seq, String email, String bookcode, int step) {
		super();
		this.seq = seq;
		this.email = email;
		this.bookcode = bookcode;
		this.step = step;
	}
	@Override
	public String toString() {
		return "Reservation_Dto [seq=" + seq + ", email=" + email + ", bookcode=" + bookcode + ", step=" + step + "]";
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
	public String getBookcode() {
		return bookcode;
	}
	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	
	
	
	
}
