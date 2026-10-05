package moviereservation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

public class Ticket {
    private String ticketId;
    private String ticketType; //Adult, Child, Senior
    private BigDecimal price;

    public Ticket(String ticketType, BigDecimal price) {
        this.ticketId = UUID.randomUUID().toString();
        this.ticketType = ticketType;
        this.price = price;
    }

    public String getTicketDetails() {
        //The price displays with exactly two decimal places
        return "Ticket ID: " + ticketId + " | Type: " + ticketType + " | Price: $" + price.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPrice() { return price; }
}