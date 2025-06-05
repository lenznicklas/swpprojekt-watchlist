package com.example.dto;

public class MovieDto {
    private Long id;
    private Integer tmdbId;
    private String title;
    private Integer year;
    private Integer duration;
    private Double rating;
    private Boolean seen;

    public MovieDto() {}

    public MovieDto(Long id, Integer tmdbId, String title,
                    Integer year, Integer duration,
                    Double rating, Boolean seen) {
        this.id = id;
        this.tmdbId = tmdbId;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.rating = rating;
        this.seen = seen;
    }

    // --- Getter / Setter ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public Boolean getSeen() { return seen; }
    public void setSeen(Boolean seen) { this.seen = seen; }
}
