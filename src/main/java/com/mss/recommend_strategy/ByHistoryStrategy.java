package com.mss.recommend_strategy;


import com.mss.auth_factory.User;
import com.mss.catalog_builder.Track;
import com.mss.catalog_builder.TrackRepository;

import java.util.List;


public class ByHistoryStrategy implements RecommendationStrategy {
    private final TrackRepository repo;

    public ByHistoryStrategy(TrackRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Track> recommend(User user) {
        // Для демо: просто берем первые 3 трека
        return repo.findAll().stream().limit(3).toList();
    }
}
