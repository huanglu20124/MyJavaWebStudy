package com.HL.domain;

import java.io.Serializable;
import java.sql.Date;

public class Customer implements Serializable{
	private int id;
	private String name;
	private String cus_type;
	private String gender;
	private String cellphone;
	private String email;
	private String preference;
	private String description;
	private Date birthday;
	
	
	
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
	public String getCus_type() {
		return cus_type;
	}
	public void setCus_type(String cus_type) {
		this.cus_type = cus_type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
