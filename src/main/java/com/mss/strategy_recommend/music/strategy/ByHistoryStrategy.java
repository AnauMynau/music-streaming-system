package com.mss.strategy_recommend.music.strategy;


import com.mss.factory_auth.music.user.User;
import com.mss.builder_catalog.Track;
import com.mss.strategy_recommend.music.repository.TrackRepository;

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
