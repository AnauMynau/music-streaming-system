package com.mss.recommend_strategy.music.repository;

import com.mss.catalog_builder.Artist;
import com.mss.catalog_builder.Track;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryTrackRepository implements TrackRepository {
    private final List<Track> data = new ArrayList<>();

    public InMemoryTrackRepository() {
        seed();
    }

    private void seed() {
        Artist a = new Artist("a1", "Imagine Dragons", "alt-rock");
        data.add(new Track.Builder()
                .id("t1")
                .title("Believer")
                .artist(a)
                .genre("alt-rock")
                .seconds(204)
                .build());
        data.add(new Track.Builder()
                .id("t2")
                .title("Thunder")
                .artist(a)
                .genre("alt-rock")
                .seconds(187)
                .build());
    }

    @Override
    public List<Track> findAll() {
        return Collections.unmodifiableList(data);
    }

    @Override
    public List<Track> searchByTitle(String q) {
        String ql = q.toLowerCase();
        return data.stream()
                .filter(t -> t.getTitle().toLowerCase().contains(ql))
                .toList();
    }
}

