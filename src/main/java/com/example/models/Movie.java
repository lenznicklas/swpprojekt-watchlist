// src/main/java/com/example/models/Movie.java
package com.example.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer tmdbId;

    @Column(nullable = false)
    private String title;

    @Column(name = "release_year")
    private Integer year;

    private Integer duration;
    private Double rating;

    // neues Flag für Watchlist
    @Column(nullable = false)
    private Boolean inWatchlist = false;

    // bestehendes Flag für Seen
    @Column(nullable = false)
    private Boolean seen = false;

    @ManyToOne
    @JsonBackReference
    private User user;

    public Movie() {}

    public Movie(Integer tmdbId, String title, Integer year, Integer duration) {
        this.tmdbId   = tmdbId;
        this.title    = title;
        this.year     = year;
        this.duration = duration;
    }



    // --- Getter/Setter ---
    public Long getId() { return id; }
    public Integer getTmdbId() { return tmdbId; }
    public void setTmdbId(Integer tmdbId) { this.tmdbId = tmdbId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }
    public Boolean getInWatchlist() { return inWatchlist; }
    public void setInWatchlist(Boolean inWatchlist) { this.inWatchlist = inWatchlist; }
    public Boolean getSeen() { return seen; }
    public void setSeen(Boolean seen) { this.seen = seen; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
