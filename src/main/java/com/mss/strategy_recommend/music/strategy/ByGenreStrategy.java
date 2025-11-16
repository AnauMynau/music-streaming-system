package com.mss.strategy_recommend.music.strategy;


import com.mss.factory_auth.music.user.User;
import com.mss.builder_catalog.Track;
import com.mss.strategy_recommend.music.repository.TrackRepository;

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

