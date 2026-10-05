package moviereservation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class BookingConfirmation {
    private String confirmationCode;
    private LocalDateTime issueDate;
    private String customerEmail;
    private String reservationDetails; // To be used with Reservation object later

    public BookingConfirmation(String customerEmail, String reservationDetails) {
        //Validation gate: Prevents generating a confirmation for an invalid/null reservation
        if (reservationDetails == null || reservationDetails.trim().isEmpty()) {
            throw new IllegalArgumentException("Validation Error: Reservation is invalid. Cannot generate confirmation.");
        }
        
        this.confirmationCode = "CONF-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.issueDate = LocalDateTime.now();
        this.customerEmail = customerEmail;
        this.reservationDetails = reservationDetails;
    }

    public String generateSummary() {
        // Creates a clean format like "10/02/2026 09:55 PM"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        
        return "--- BOOKING CONFIRMATION ---\n" +
               "Code: " + confirmationCode + "\n" +
               "Date Issued: " + issueDate.format(formatter) + "\n" +
               "Customer Email: " + customerEmail + "\n" +
               "Details: " + reservationDetails + "\n" +
               "----------------------------";
    }

    public void sendConfirmationEmail() {
        System.out.println("Sending email to " + customerEmail + "...\n" + generateSummary());
    }
}