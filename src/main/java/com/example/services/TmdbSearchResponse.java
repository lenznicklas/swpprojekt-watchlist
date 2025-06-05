package com.example.dto;

import java.util.List;

public class TmdbSearchResponse {

    private List<TmdbMovieDto> results;

    public List<TmdbMovieDto> getResults() {
        return results;
    }

    public void setResults(List<TmdbMovieDto> results) {
        this.results = results;
    }
}
