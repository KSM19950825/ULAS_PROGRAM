package com.las.khj.dto;

import java.io.Serializable;

public class Member_Dto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6510268239559475783L;
	
	private String email;
	private String password;
	private String name;
	private String address;
	private String phone;
	private String delflag;
	private String auth;
	private int penalty;
	public Member_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member_Dto(String email, String password, String name, String address, String phone, String delflag,
			String auth, int penalty) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.delflag = delflag;
		this.auth = auth;
		this.penalty = penalty;
	}
	@Override
	public String toString() {
		return "memberDto [email=" + email + ", password=" + password + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + ", delflag=" + delflag + ", auth=" + auth + ", penalty=" + penalty + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public int getPenalty() {
		return penalty;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
