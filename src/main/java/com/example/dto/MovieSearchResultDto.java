package com.example.dto;

public class MovieSearchResultDto {
    private Integer tmdbId;
    private String title;
    private Integer year;
    private Integer duration;   // in Minuten
    private String posterUrl;

    public MovieSearchResultDto(Integer tmdbId, String title, Integer year, Integer duration, String posterUrl) {
        this.tmdbId   = tmdbId;
        this.title    = title;
        this.year     = year;
        this.duration = duration;
        this.posterUrl = posterUrl;
    }

    // Getter (Setter optional, je nach Bedarf)
    public Integer getTmdbId() { return tmdbId; }
    public String getTitle()    { return title;  }
    public Integer getYear()    { return year;   }
    public Integer getDuration(){ return duration; }
    public String getPosterUrl(){ return posterUrl; }
}
