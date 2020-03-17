package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date checkIn;
	private Date checkOut;
	private Integer roomNumber;

	public Reservation() {
	}

	public Reservation(Date checkIn, Date checkOut, Integer roomNumber) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomNumber = roomNumber;
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out dates must be after check-in date");
		}
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // A classe TimeUnit converte milissegundos em dias
	}

	public void updateDates(Date checkIn, Date checkOut) {

		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) { // testando se as datas são antes da data atual
			 throw new DomainException("Reservation dates for update must be future dates");
		}
		
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out dates must be after check-in date");
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room: " 
	            + roomNumber
	            + ", check-in: "
				+ sdf.format(checkIn) 
				+ ", check-out " 
				+ sdf.format(checkOut)
				+ ", " 
				+ duration() 
				+ " nights";
	}

}
