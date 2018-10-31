package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			
			System.out.print("Check-in date (DD/MM/YYYY): ");
			Date checkIn =sdf.parse(sc.next());
			
			System.out.print("Check-out date (DD/MM/YYYY): ");
			Date checkOut =sdf.parse(sc.next());
			 
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: "+reservation);
			System.out.println();
			System.out.println("Enter data to up update reservation: ");
		
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn =sdf.parse(sc.next());
			
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut =sdf.parse(sc.next());
			
			reservation.updateDatas(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date");
		}
		
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		
		catch(RuntimeException e) {
			System.out.println("Inexpected error: " + e.getMessage());
		}
		
		
		
		sc.close();
	}

}
