// src/main/java/com/example/controllers/WatchlistController.java
package com.example.controllers;

import com.example.models.Movie;
import com.example.models.User;
import com.example.repositories.MovieRepository;
import com.example.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies/{userId}")
@CrossOrigin(origins = "http://localhost:8081")
public class WatchlistController {

    private final MovieRepository movieRepo;
    private final UserRepository  userRepo;

    public WatchlistController(MovieRepository movieRepo, UserRepository userRepo) {
        this.movieRepo = movieRepo;
        this.userRepo  = userRepo;
    }

    /** Liefert alle Filme eines Users **/
    @GetMapping
    public List<Movie> all(@PathVariable Long userId) {
        return movieRepo.findByUserId(userId);
    }

    /** Upsert via JSON-POST – **keine** consumes-Angabe! **/
    @PostMapping
    public Movie upsert(
            @PathVariable Long userId,
            @RequestBody Movie payload
    ) {
        User u = userRepo.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Movie m = movieRepo.findByUserIdAndTmdbId(userId, payload.getTmdbId())
                .orElseGet(() -> {
                    Movie neu = new Movie(
                            payload.getTmdbId(),
                            payload.getTitle(),
                            payload.getYear(),
                            payload.getDuration()
                    );
                    neu.setUser(u);
                    return neu;
                });

        m.setInWatchlist(payload.getInWatchlist());
        m.setSeen       (payload.getSeen());
        return movieRepo.save(m);
    }

    /** Löscht einen Film komplett **/
    @DeleteMapping("/{movieId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long userId,
            @PathVariable Long movieId
    ) {
        Movie m = movieRepo.findById(movieId)
                .filter(x -> x.getUser().getId().equals(userId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
        movieRepo.delete(m);
    }
}
