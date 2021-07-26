package com.las.khj.dto;

import java.io.Serializable;

public class Otp_Dto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -107204660233202410L;
	private String email;
	private int otp;
	public Otp_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Otp_Dto(String email, int otp) {
		super();
		this.email = email;
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "otpDto [email=" + email + ", otp=" + otp + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	
}
