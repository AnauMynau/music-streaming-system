package com.mss.recommend_strategy;

import com.mss.auth_factory.User;
import com.mss.catalog_builder.Track;

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
