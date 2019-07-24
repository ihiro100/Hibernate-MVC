package com.Learning.MVC_Learning.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String display_name;
	private int no_of_rooms;
	private String complete_address;
	@OneToMany(mappedBy = "hotel")
	private List<Customer> customer = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public int getNo_of_rooms() {
		return no_of_rooms;
	}
	public void setNo_of_rooms(int no_of_rooms) {
		this.no_of_rooms = no_of_rooms;
	}
	public String getComplete_address() {
		return complete_address;
	}
	public void setComplete_address(String complete_address) {
		this.complete_address = complete_address;
	}
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", display_name=" + display_name + ", no_of_rooms=" + no_of_rooms
				+ ", complete_address=" + complete_address + ", customer=" + customer + "]";
	}
	
}
