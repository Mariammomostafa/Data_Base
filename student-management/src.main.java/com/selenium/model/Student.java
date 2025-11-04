package com.selenium.model;

public class Student {
	
	private int id ;
	private String name;
	private String mobile;
	private String country;
	
	
	
	public Student() {
		super();
	}
	public Student(int id, String name, String mobile, String country) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + ", country=" + country + "]";
	}
	
	

}
