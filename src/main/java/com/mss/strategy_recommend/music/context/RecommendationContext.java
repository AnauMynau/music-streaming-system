package com.mss.strategy_recommend.music.context;

import com.mss.factory_auth.music.user.User;
import com.mss.builder_catalog.Track;
import com.mss.strategy_recommend.music.strategy.RecommendationStrategy;

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
