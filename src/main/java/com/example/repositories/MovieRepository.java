package com.example.repositories;

import com.example.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Gibt alle Filme eines Users zurück
    List<Movie> findByUserId(Long userId);

    // (Optional) nur die in der Watchlist
    List<Movie> findByUserIdAndInWatchlistTrue(Long userId);

    // (Optional) nur die als gesehen markierten
    List<Movie> findByUserIdAndSeenTrue(Long userId);

    // (Optional) um Upsert nach tmdbId zu ermöglichen
    Optional<Movie> findByUserIdAndTmdbId(Long userId, Integer tmdbId);
}
