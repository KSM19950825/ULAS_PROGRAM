package com.las.khj.dto;

import java.io.Serializable;
import java.util.List;

public class Reservation_Dto implements Serializable {

	private static final long serialVersionUID = -7900758915589122645L;
	
	private int seq      ;
	private String bookseq ;
	private int step     ;
	private String title;
	public Reservation_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation_Dto(int seq, String bookseq, int step, String title) {
		super();
		this.seq = seq;
		this.bookseq = bookseq;
		this.step = step;
		this.title = title;
	}
	@Override
	public String toString() {
		return "Reservation_Dto [seq=" + seq + ", bookseq=" + bookseq + ", step=" + step + ", title=" + title + "]";
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getBookseq() {
		return bookseq;
	}
	public void setBookseq(String bookseq) {
		this.bookseq = bookseq;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
	
	
}
