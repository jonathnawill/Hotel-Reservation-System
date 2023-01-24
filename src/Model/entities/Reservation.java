package Model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {
	
	public static DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate chekcout;
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate chekcout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.chekcout = chekcout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getChekcout() {
		return chekcout;
	}
	
	public long duration() {
		 Period duration = Period.between(checkin, chekcout);
	        return duration.getDays();
	}
	
	public String updateDates(LocalDate checkin, LocalDate checkout) {
		LocalDate now = LocalDate.now();
		if(checkin.isBefore(now) || checkout.isBefore(now) ) {
			return " Reservation dates for update must be future dates";
		}
		if(! checkout.isAfter(checkin)) {
			return "Check-out date must be after check-in date";
		}	
		this.checkin = checkin;
		this.chekcout = checkout;
		return null;
	}

	@Override
	public String toString() {
		return "Reservation: "
			+  "Room "
			+  roomNumber
			+  ", "
			+  "check-in: "
			+ formatador.format(checkin)
		    + ", "
		    + "check-out: "
		    + formatador.format(chekcout)
		    + ", "
		    + duration()
		    + " nights";
	
	}
	
	
	
	
}
