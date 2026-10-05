package moviereservation;

import java.util.UUID;

public class Reservation {

    private String reservationId;
    private String customerEmail;
    private Showtime showtime;
    private Seat seat;
    private boolean active;

    // Creates a reservation if all information is valid
    public Reservation(String customerEmail, Showtime showtime, Seat seat) {

        if (customerEmail == null || customerEmail.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer email is required.");
        }

        if (showtime == null) {
            throw new IllegalArgumentException("Showtime is required.");
        }

        if (seat == null) {
            throw new IllegalArgumentException("Seat is required.");
        }

        // Prevents that the seats duplicates reservation
        if (!seat.isAvailable()) {
            throw new IllegalStateException("Seat is already reserved.");
        }

        this.reservationId = UUID.randomUUID().toString();
        this.customerEmail = customerEmail;
        this.showtime = showtime;
        this.seat = seat;
        this.active = true;

        seat.reserveSeat();
    }

    // canceling the reservation and it releases the seat
    public void cancelReservation() {
        if (active) {
            active = false;
            seat.releaseSeat();
        }
    }

    public String getReservationDetails() {
        return "Reservation ID: " + reservationId
                + " | Customer: " + customerEmail
                + " | Movie: " + showtime.getMovie().getTitle()
                + " | Seat: " + seat.getSeatLabel();
    }

    public boolean isActive() {
        return active;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public Seat getSeat() {
        return seat;
    }
}