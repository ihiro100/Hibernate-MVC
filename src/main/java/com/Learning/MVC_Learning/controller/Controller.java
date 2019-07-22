package com.Learning.MVC_Learning.controller;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Learning.MVC_Learning.beans.Hotel;
import com.Learning.MVC_Learning.beans.User;
import com.Learning.MVC_Learning.model.Model;

public class Controller {
	public void registerUser(Hotel h) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer's name.. ");
		String name = sc.nextLine();
		System.out.println("Enter Customer's Phone.. ");
		String phone = sc.nextLine();
		User u = new User();
		u.setName(name);
		u.setName(phone);
		new Model().registerUser(h,u);
	}

	public void getUser(Hotel h) {
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		new Model().getUser(h,id);
	}

	public void checkInUser() {
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		new Model().checkInUser(id);
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
}
