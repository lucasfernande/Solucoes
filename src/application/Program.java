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

			Date now = new Date();
			
			if (checkIn.before(now) || checkOut.before(now)) { // testando se as datas são antes da data atual
				System.out.println("Error in reservation: Reservation date for update must be future dates");
			}
			else if (checkOut.before(checkIn)) {
				System.out.println("Error in reservation: Check-out dates must be after check-in date");
			}
			
			else {
                reserv.updateDates(checkIn, checkOut);
                System.out.println();
				System.out.println("Updated reservation: " + reserv);
			}
		}

		sc.close();

	}

}
