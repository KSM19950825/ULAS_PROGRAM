package com.las.khj.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Rent_Dto implements Serializable{

	private static final long serialVersionUID = 512546276688975301L;
	
	private int seq        ;
	private String  start_date;
	private String return_date;
	private String title;
	public Rent_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rent_Dto(int seq, String start_date, String return_date, String title) {
		super();
		this.seq = seq;
		this.start_date = start_date;
		this.return_date = return_date;
		this.title = title;
	}
	@Override
	public String toString() {
		return "Rent_Dto [seq=" + seq + ", start_date=" + start_date + ", return_date=" + return_date + ", title="
				+ title + "]";
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
