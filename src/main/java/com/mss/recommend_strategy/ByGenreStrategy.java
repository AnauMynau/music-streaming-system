package com.mss.recommend_strategy;


import com.mss.auth_factory.User;
import com.mss.catalog_builder.Track;
import com.mss.catalog_builder.TrackRepository;

import java.util.List;


public class ByGenreStrategy implements RecommendationStrategy {
    private final String genre;
    private final TrackRepository repo;

    public ByGenreStrategy(String genre, TrackRepository repo) {
        this.genre = genre;
        this.repo = repo;
    }

    @Override
    public List<Track> recommend(User user) {
        return repo.findAll().stream()
                .filter(t -> t.getGenre().equalsIgnoreCase(genre))
                .toList();
    }
}

