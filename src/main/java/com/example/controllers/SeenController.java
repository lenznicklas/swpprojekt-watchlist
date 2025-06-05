// src/main/java/com/example/controllers/SeenController.java
package com.example.controllers;

import com.example.models.Movie;
import com.example.models.User;
import com.example.repositories.MovieRepository;
import com.example.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@RestController
@RequestMapping("/api/seen/{userId}")
@CrossOrigin("http://localhost:8081")
public class SeenController {

    private final MovieRepository movieRepo;
    private final UserRepository  userRepo;

    public SeenController(MovieRepository movieRepo, UserRepository userRepo) {
        this.movieRepo = movieRepo;
        this.userRepo  = userRepo;
    }

    // Liste aller als gesehen markierten Filme
    @GetMapping
    public List<Movie> list(@PathVariable Long userId) {
        return movieRepo.findByUserIdAndSeenTrue(userId);
    }

    // Toggle Seen-Flag (mark/unmark)
    @PutMapping("/{movieId}")
    public Movie toggle(
            @PathVariable Long userId,
            @PathVariable Long movieId
    ) {
        Movie m = movieRepo.findById(movieId)
                .filter(x -> x.getUser().getId().equals(userId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        m.setSeen(!m.getSeen());
        return movieRepo.save(m);
    }
}
