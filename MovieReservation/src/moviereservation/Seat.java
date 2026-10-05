package moviereservation;

import java.util.UUID;

public class Seat {
	// Creating a new seat
    private String seatId;
    private String rowNumber;
    private int seatNumber;
    private boolean wheelchairAccessible;
    private boolean reserved;

    public Seat(String rowNumber, int seatNumber, boolean wheelchairAccessible) {
        this.seatId = UUID.randomUUID().toString();
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.wheelchairAccessible = wheelchairAccessible;
        this.reserved = false;
    }
 // Checks if the seat is available
    public boolean isAvailable() { 
        return !reserved;
    }

    public void reserveSeat() {
        if (reserved) {
            throw new IllegalStateException("Seat is already reserved."); // Seat is reserved
        }
        reserved = true;
    }

    public void releaseSeat() { 
        reserved = false; // After cancellation the seat is released
    }

    public boolean isWheelchairAccessible() {
        return wheelchairAccessible;
    }

    public String getSeatLabel() {
        return rowNumber + seatNumber;
    }

    public boolean isReserved() {
        return reserved;
    }

    public String getSeatId() {
        return seatId;
    }
}
