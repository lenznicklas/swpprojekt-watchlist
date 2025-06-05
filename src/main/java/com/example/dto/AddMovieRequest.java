package com.example.dto;

public class AddMovieRequest {
    private Integer tmdbId;
    private String title;
    private Integer year;
    private Integer duration;
    private Boolean seen;   // neu

    public AddMovieRequest() {}

    public Integer getTmdbId()    { return tmdbId; }
    public void setTmdbId(Integer tmdbId) { this.tmdbId = tmdbId; }

    public String getTitle()      { return title; }
    public void setTitle(String title)   { this.title = title; }

    public Integer getYear()      { return year; }
    public void setYear(Integer year)     { this.year = year; }

    public Integer getDuration()  { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public Boolean getSeen()      { return seen; }
    public void setSeen(Boolean seen)       { this.seen = seen; }
}
