package com.example.services;

import com.example.dto.TmdbMovieDto;
import com.example.dto.TmdbSearchResponse;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class TmdbService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Sucht Filme über den TMDB Search-Endpoint.
     */
    public List<TmdbMovieDto> searchMovies(String query) {
        String url = String.format("%s/search/movie?api_key=%s&query=%s", baseUrl, apiKey, query);
        TmdbSearchResponse response = restTemplate.getForObject(url, TmdbSearchResponse.class);
        return (response != null) ? response.getResults() : Collections.emptyList();
    }

    /**
     * Holt die Laufzeit eines Films über den TMDB Movie-Detail-Endpoint.
     */
    public Integer fetchRuntime(Integer tmdbId) {
        String url = String.format("%s/movie/%d?api_key=%s", baseUrl, tmdbId, apiKey);
        JsonNode node = restTemplate.getForObject(url, JsonNode.class);
        if (node != null && node.has("runtime") && !node.get("runtime").isNull()) {
            return node.get("runtime").asInt();
        }
        return null;
    }
}
