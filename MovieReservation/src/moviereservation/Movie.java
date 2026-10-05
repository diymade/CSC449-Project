package moviereservation;

import java.util.UUID;

public class Movie {
    private String movieId;
    private String title;
    private String genre;
    private int durationMinutes;
    private String rating;

    public Movie(String title, String genre, int durationMinutes, String rating) {
        this.movieId = UUID.randomUUID().toString();
        this.title = title;
        this.genre = genre;
        this.durationMinutes = durationMinutes;
        this.rating = rating;
    }

    public String getMovieDetails() {
        return title + " (" + rating + ") - " + genre + " | " + durationMinutes + " mins";
    }

    public void updateDetails(String title, int durationMinutes, String rating) {
        this.title = title;
        this.durationMinutes = durationMinutes;
        this.rating = rating;
    }

    public String getMovieId() { return movieId; }
    public String getTitle() { return title; }
}