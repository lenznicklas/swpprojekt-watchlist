package com.example.controllers;

import com.example.models.Movie;
import com.example.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin("http://localhost:8081")
public class MovieController {

    @Autowired
    private MovieRepository movieRepo;

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepo.save(movie);
    }

    @GetMapping("/user/{userId}")


    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieRepo.deleteById(id);
    }
}
