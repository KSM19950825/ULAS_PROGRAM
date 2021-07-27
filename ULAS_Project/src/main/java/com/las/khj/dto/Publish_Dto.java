package com.las.khj.dto;

import java.io.Serializable;

public class Publish_Dto implements Serializable{

	private static final long serialVersionUID = 5758239425437359292L;

	private String publcode;
	private String publisher;
	public String getPublcode() {
		return publcode;
	}
	public void setPublcode(String publcode) {
		this.publcode = publcode;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Publish_Dto [publcode=" + publcode + ", publisher=" + publisher + "]";
	}
	
	
}
