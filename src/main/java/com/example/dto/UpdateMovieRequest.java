package com.example.dto;

public class UpdateMovieRequest {
    private Double rating;
    private Boolean seen;

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }
    public Boolean getSeen() { return seen; }
    public void setSeen(Boolean seen) { this.seen = seen; }
}
