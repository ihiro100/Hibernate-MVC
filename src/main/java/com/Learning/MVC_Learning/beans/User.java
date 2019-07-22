package com.Learning.MVC_Learning.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone_no;
	private boolean check_in;
	@ManyToOne
	private Hotel hotel;
	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public boolean isCheck_in() {
		return check_in;
	}
	public void setCheck_in(boolean check_in) {
		this.check_in = check_in;
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
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone_no=" + phone_no + ", hotel"+ hotel + "]";
	}
	
}
