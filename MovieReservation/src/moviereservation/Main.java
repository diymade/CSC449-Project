package moviereservation;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- SYSTEM TEST START ---\n");

        //Direct Catalog of movie(s)
        Movie movie1 = new Movie("The Fast and the Furious", "Action", 106, "PG-13");
        System.out.println("Loaded Movie: " + movie1.getMovieDetails());

        Showtime showtime1 = new Showtime(
            movie1, 
            LocalDateTime.now().plusDays(1), 
            LocalDateTime.now().plusDays(1).plusMinutes(136), 
            new BigDecimal("15.50")
        );
        System.out.println("Loaded Showtime for: " + showtime1.getMovie().getTitle());

        System.out.println("\n--- TICKET PRICING TEST ---");
        // 2. Test Ticket Formatting 
        Ticket adultTicket = new Ticket("Adult", showtime1.getBasePrice());
        System.out.println(adultTicket.getTicketDetails());

        System.out.println("\n--- BOOKING CONFIRMATION TEST ---");
        // 3. Test Booking Confirmation Generation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        String mockReservationData = "Movie: The Fast and the Furious | Seat: F12 | Showtime: " + showtime1.getStartTime().format(formatter);
        BookingConfirmation confirmation = new BookingConfirmation("customer@email.com", mockReservationData);
        confirmation.sendConfirmationEmail();

        System.out.println("\n--- VALIDATION ERROR TEST ---");
        // 4. Test Validation Gate 
        try {
            System.out.println("Attempting to generate confirmation for a null reservation...");
            new BookingConfirmation("customer@email.com", "");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }
    }
}