package moviereservation.tests;

import moviereservation.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReservationJUnitTest {

    @Test
    public void testDuplicateReservationIsBlocked() {
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

        // First reservation reserves the seat
        Reservation first = new Reservation("customer@email.com", showtime, seat);
        assertFalse(seat.isAvailable());   // seat should now be reserved

        // Second reservation should fail
        try {
            new Reservation("second@email.com", showtime, seat);
            fail("Expected IllegalStateException for duplicate reservation");
        } catch (IllegalStateException e) {
            assertEquals("Seat is already reserved.", e.getMessage());
        }
    }

    @Test
    public void testCancelReservationReleasesSeat() {
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

        Reservation reservation = new Reservation("test@email.com", showtime, seat);

        // Seat should be reserved
        assertFalse(seat.isAvailable());

        // Cancel reservation
        reservation.cancelReservation();

        // Seat should now be available
        assertTrue(seat.isAvailable());
        assertFalse(reservation.isActive());
    }
}
