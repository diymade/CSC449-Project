package moviereservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Showtime {
    private String showtimeId;
    private Movie movie;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal basePrice;
    private boolean isSoldOut;

    public Showtime(Movie movie, LocalDateTime startTime, LocalDateTime endTime, BigDecimal basePrice) {
        this.showtimeId = UUID.randomUUID().toString();
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
        this.basePrice = basePrice;
        this.isSoldOut = false;
    }

    public void updateSoldOutStatus(boolean status) {
        this.isSoldOut = status;
    }

    public String getShowtimeId() { return showtimeId; }
    public Movie getMovie() { return movie; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public BigDecimal getBasePrice() { return basePrice; }
    public boolean isSoldOut() { return isSoldOut; }
    
    public void setBasePrice(BigDecimal basePrice) { 
        this.basePrice = basePrice; 
    }
}