package moviereservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReservationTest {

    public static void main(String[] args) {

        Movie movie = new Movie(
                "The Fast and the Furious",
                "Action",
                106,
                "PG-13"
        );

        Showtime showtime = new Showtime(
                movie,
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusMinutes(136),
                new BigDecimal("15.50")
        );

        Seat seat = new Seat("F", 12, true);
        System.out.println("Wheelchair Accessible: " + seat.isWheelchairAccessible());
        System.out.println("--- RESERVATION TEST ---");

        Reservation reservation =
                new Reservation("customer@email.com", showtime, seat);

        System.out.println(reservation.getReservationDetails());

        System.out.println("\n--- DUPLICATE SEAT TEST ---");

        try {
            new Reservation("second@email.com", showtime, seat);
        } catch (IllegalStateException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        System.out.println("\n--- CANCELLATION TEST ---");

        reservation.cancelReservation();

        System.out.println("Seat Available: " + seat.isAvailable());
    }
}