package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.nextLine(), formatador);
		System.out.print("Check-out date (dd/MM/yyyy):");
		LocalDate checkOut = LocalDate.parse(sc.nextLine(), formatador);
		
		if(! checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			
			Reservation reserv = new Reservation(number, checkIn, checkOut);
			System.out.println(reserv);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.nextLine(), formatador);
			System.out.print("Check-out date (dd/MM/yyyy):");
			checkOut = LocalDate.parse(sc.nextLine(), formatador);
			
			LocalDate now = LocalDate.now();
			if(checkIn.isBefore(now) || checkOut.isBefore(now) ) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates" );
			}
			else if(! checkOut.isAfter(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reserv.updateDates(checkIn, checkOut);
				System.out.println(reserv);		
			}
			
		}
		
	
	}

}
