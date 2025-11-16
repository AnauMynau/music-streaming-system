package com.mss.catalog_builder;

import java.util.List;

public interface TrackRepository {
    List<Track> findAll();
    List<Track> searchByTitle(String q);
}

