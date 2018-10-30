package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		
		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkIn =sdf.parse(sc.next());
		
		System.out.print("Check-out date (DD/MM/YYYY): ");
		Date checkOut =sdf.parse(sc.next());
		
		if(checkIn.after(checkOut)) {
			System.out.println("Error in resavertion: Check-out must be after check-in date");
		} 
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: "+reservation);
			System.out.println();
			System.out.println("Enter data to up update reservation: ");
		
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn =sdf.parse(sc.next());
			
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut =sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.after(checkOut)) {
				System.out.println("Error in Reservateion: Check-out date must be after check-in date");
			}
			else if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservateions dates for update must be future dates");
			}
		
		}
		
		
		
		sc.close();
	}

}
