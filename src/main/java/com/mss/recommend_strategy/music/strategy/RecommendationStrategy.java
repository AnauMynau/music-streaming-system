package com.mss.recommend_strategy.music.strategy;


import com.mss.auth_factory.music.user.User;
import com.mss.catalog_builder.Track;

import java.util.List;

public interface RecommendationStrategy {
    List<Track> recommend(User user);
}

