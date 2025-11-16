package com.mss.recommend_strategy.music.strategy;


import com.mss.auth_factory.music.user.User;
import com.mss.catalog_builder.Track;
import com.mss.recommend_strategy.music.repository.TrackRepository;

import java.util.List;


public class ByHistoryStrategy implements RecommendationStrategy {
    private final TrackRepository repo;

    public ByHistoryStrategy(TrackRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Track> recommend(User user) {
        return repo.findAll().stream().limit(3).toList();
    }
}
