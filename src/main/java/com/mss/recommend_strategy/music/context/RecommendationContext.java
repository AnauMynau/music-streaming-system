package com.mss.recommend_strategy.music.context;

import com.mss.auth_factory.music.user.User;
import com.mss.catalog_builder.Track;
import com.mss.recommend_strategy.music.strategy.RecommendationStrategy;

import java.util.List;


public class RecommendationContext {
    private RecommendationStrategy strategy;

    public RecommendationContext(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Track> recommend(User user) {
        return strategy.recommend(user);
    }
}
