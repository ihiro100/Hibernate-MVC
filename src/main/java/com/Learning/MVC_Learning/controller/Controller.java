package com.Learning.MVC_Learning.controller;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Learning.MVC_Learning.beans.Hotel;
import com.Learning.MVC_Learning.beans.Customer;
import com.Learning.MVC_Learning.model.Model;

public class Controller {
	public void registerUser(Hotel h) {
		Scanner sc = new Scanner(System.in);
		Customer c = new Customer();
		System.out.println("Enter Customer's name.. ");
		String name = sc.next();
		c.setName(name);
		System.out.println("Enter Customer's Phone.. ");
		String phone = sc.next();
		c.setPhone_no(phone);
		h.getCustomer().add(c);
		c.setCheck_in(false);
		c.setHotel(h);
		
		System.out.println("--------------- "+ h + "\n" +c);
		
		new Model().registerUser(h,c);
		
		System.out.println("---------------");
	}

	public Customer getUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user Id.. ");
		int id = sc.nextInt();
		return new Model().getUser(id);
	}

	public void checkInToggleUser(boolean status) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer Id");
		int id = sc.nextInt();
		if(new Model().getUser(id)!=null) new Model().checkInToggleUser(id,status);
		else System.out.println("we couldn't find user in DB");
	}

	public Hotel addHotel() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of rooms.. ");
		int no_of_rooms = sc.nextInt();
		System.out.println("Enter hotel's name.. ");
		String display_name = sc.next();
		System.out.println("Enter hotel's complete address.. ");
		String complete_address = sc.next();
		Hotel h = new Hotel();
		h.setNo_of_rooms(no_of_rooms);
		h.setDisplay_name(display_name);
		h.setComplete_address(complete_address);
		System.out.println(h);
		new Model().addHotel(h);
		return h;
	}

	public void updateHotel() {
		Scanner sc = new Scanner(System.in);
		Model model = new Model();

		System.out.println("Enter hotel id.. ");
		int hotel_id = sc.nextInt();
		Hotel h = model.getHotel(hotel_id);

		System.out.println("Hotel's information \n" + h);
		if (h != null) {
			System.out.println("Enter no of rooms.. ");
			int no_of_rooms = sc.nextInt();
			System.out.println("Enter hotel's name.. ");
			String display_name = sc.next();
			System.out.println("Enter hotel's complete address.. ");
			String complete_address = sc.next();

			h.setNo_of_rooms(no_of_rooms);
			h.setDisplay_name(display_name);
			h.setComplete_address(complete_address);

			model.updateHotel(h);
		} else System.out.println("Hotel doesnot exist");

	}
	
	public Hotel getHotelLobyy(){
		Scanner sc = new Scanner(System.in);
		Model model = new Model();

		System.out.println("Enter hotel id.. ");
		int hotel_id = sc.nextInt();
		Hotel h = model.getHotel(hotel_id);
		return h!=null?h:null;

	}

	public void removeHotel() {
		Scanner sc = new Scanner(System.in);
		Model model = new Model();

		System.out.println("Enter hotel id.. ");
		int hotel_id = sc.nextInt();
		Hotel h = model.getHotel(hotel_id);

		System.out.println("Hotel's information \n" + h);
		if(h!=null) {
			model.removeHotel(h);
		} else System.out.println("Hotel does not exist");
	}
	
	public void deleteUser(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer Id");
		int id = sc.nextInt();
		Customer cust = new Model().getUser(id);
		System.out.println(cust);
		if(cust!=null) new Model().deleteUser(cust.getId());
		else System.out.println("we couldn't find user in DB");
	}
}
