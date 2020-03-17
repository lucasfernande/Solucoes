package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();

		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next());

		System.out.print("Check-out date(DD/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: check-out date must be after check-in date");
		} else {
			Reservation reserv = new Reservation(checkIn, checkOut, roomNumber);
			System.out.println("Reservation: " + reserv);

			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());

			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());

			String error = reserv.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} 
			else {
				System.out.println();
				System.out.println("Updated reservation: " + reserv);
			}
		}

		sc.close();

	}

}
