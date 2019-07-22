package com.Learning.MVC_Learning;

import java.util.Random;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Learning.MVC_Learning.beans.Hotel;
import com.Learning.MVC_Learning.controller.Controller;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("App started");

		Scanner sc = new Scanner(System.in);

		// Hotel h1 = new Hotel();
		//
		// h1.setId(1);
		// h1.setDisplay_name("Arena");
		//
		// h1.setNo_of_rooms(500);
		// h1.setComplete_address("Chakrata Dehradun");
		//
		//
		//
		// Configuration configuration = new
		// Configuration().configure().addAnnotatedClass(Hotel.class);
		// SessionFactory sf = configuration.buildSessionFactory();
		// Session session = sf.openSession();
		// Transaction tx = session.beginTransaction();
		// session.save(h1);
		// tx.commit();

		int choice;
		Controller controller = new Controller();
		do {
			System.out.println("1. Add Hotel");
			System.out.println("2. Update in Hotel");
			System.out.println("3. Remove Hotel");
			System.out.println("9. Exit App");
			System.out.println();
			choice = sc.nextInt();
			try {
				switch (choice) {
				case 1:
					Hotel h = controller.addHotel();
					int ch ;
					do {
						System.out.println("4. Register a Customer");
						System.out.println("5. View a Customer by Id");
						System.out.println("6. Check IN a Customer");
						System.out.println("7. Check OUT a Customer");
						System.out.println("8. Delete a Customer");
						System.out.println("9. Back to Main Menu");
						
						ch = sc.nextInt();
						switch (ch) {
						case 4:
							controller.registerUser(h);
							System.out.println("Registered successfull");
							break;
						case 5:
							controller.getUser(h);
							System.out.println("Registered successfull");
							break;
						case 6:
							controller.registerUser(h);
							System.out.println("Registered successfull");
							break;
						case 7:
							controller.registerUser(h);
							System.out.println("Registered successfull");
							break;
						case 8:
							controller.registerUser(h);
							System.out.println("Registered successfull");
							break;
						default:
							System.out.println("could not recogize... ");
							break;
						}
						
					} while(ch!=9);
					break;
				case 2:
					controller.updateHotel();
					break;
				case 3:
					controller.removeHotel();
					break;	
				default:
					System.out.println("didnt recognize your choice, for exit choose option 9");
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} while (choice != 9);

	}
}
