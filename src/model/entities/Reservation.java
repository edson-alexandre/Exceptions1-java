package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if(checkIn.after(checkOut)) {
			throw new DomainException("Check-in date must be after check-out");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDatas(Date checkIn , Date checkOut) {
		
		Date now = new Date();
		if(checkIn.after(checkOut)) {
			throw new DomainException ("Error in Reservateion: Check-out date must be after check-in date");
		}
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Error in reservation: Reservateions dates for update must be future dates");
		}
		this.checkIn=checkIn;
		this.checkOut=checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
			+ getRoomNumber()
			+", Check - in: "
			+sdf.format(checkIn)
			+", Check - out: "
			+sdf.format(checkOut)
			+", "+
			duration()
			+" nights";
	}
	
	
}
