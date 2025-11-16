package com.mss.catalog_builder;

public class Artist {
    private final String id;
    private final String name;
    private final String genre;

    public Artist(String id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getGenre() { return genre; }
}
