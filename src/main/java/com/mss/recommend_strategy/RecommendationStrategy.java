package com.mss.recommend_strategy;


import com.mss.auth_factory.User;
import com.mss.catalog_builder.Track;

import java.util.List;

public interface RecommendationStrategy {
    List<Track> recommend(User user);
}

