package com.mss.strategy_recommend.music.strategy;


import com.mss.factory_auth.music.user.User;
import com.mss.builder_catalog.Track;

import java.util.List;

public interface RecommendationStrategy {
    List<Track> recommend(User user);
}

