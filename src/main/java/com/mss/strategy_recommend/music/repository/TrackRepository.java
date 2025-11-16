package com.mss.strategy_recommend.music.repository;

import com.mss.builder_catalog.Track;

import java.util.List;

public interface TrackRepository {
    List<Track> findAll();
    List<Track> searchByTitle(String q);
}

