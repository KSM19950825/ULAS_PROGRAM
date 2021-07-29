package com.las.khj.dto;

import java.io.Serializable;

public class Class_Dto implements Serializable{

	private static final long serialVersionUID = -3693497169511576660L;

	private String classcode;
	private String classname;
	public String getClasscode() {
		return classcode;
	}
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	@Override
	public String toString() {
		return "Class_Dto [classcode=" + classcode + ", classname=" + classname + "]";
	}
	
	
}
