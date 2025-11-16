package com.mss.recommend_strategy.music.repository;

import com.mss.catalog_builder.Track;

import java.util.List;

public interface TrackRepository {
    List<Track> findAll();
    List<Track> searchByTitle(String q);
}

