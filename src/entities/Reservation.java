package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date checkIn;
	private Date checkOut;
	private Integer roomNumber;
	
	public Reservation() {
	}

	public Reservation(Date checkIn, Date checkOut, Integer roomNumber) {
		super();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomNumber = roomNumber;
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
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room: " + roomNumber +
				", check-in: " 
				+ sdf.format(checkIn) 
				+ ", check-out " 
				+ sdf.format(checkOut)
				+ ", "
				+ duration() +
				" nights";
	}
	
	
}
