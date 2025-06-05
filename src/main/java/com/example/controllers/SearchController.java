package com.example.controllers;

import com.example.dto.MovieSearchResultDto;
import com.example.dto.TmdbMovieDto;
import com.example.services.TmdbService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin("http://localhost:8081")
public class SearchController {
    private final TmdbService tmdbService;
    private final String posterBase = "https://image.tmdb.org/t/p/w200";

    public SearchController(TmdbService tmdbService) {
        this.tmdbService = tmdbService;
    }

    @GetMapping("/search")
    public List<MovieSearchResultDto> search(@RequestParam String query) {
        List<TmdbMovieDto> results = tmdbService.searchMovies(query);
        return results.stream().map(dto -> {
            Integer year = null;
            if (dto.getReleaseDate() != null && dto.getReleaseDate().length() >= 4) {
                year = Integer.parseInt(dto.getReleaseDate().substring(0,4));
            }
            // Für Runtime den Detail-Call, sonst null
            Integer runtime = tmdbService.fetchRuntime(dto.getId());
            String posterUrl = dto.getPosterPath() != null
                    ? posterBase + dto.getPosterPath()
                    : null;
            return new MovieSearchResultDto(
                    dto.getId(),
                    dto.getTitle(),
                    year,
                    runtime,
                    posterUrl
            );
        }).collect(Collectors.toList());
    }
}
