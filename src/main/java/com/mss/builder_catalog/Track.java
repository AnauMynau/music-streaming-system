package com.mss.builder_catalog;

public class Track {
    private final String id;
    private final String title;
    private final String genre;
    private final Artist artist;
    private final int seconds;

    private Track(Builder b) {
        this.id = b.id;
        this.title = b.title;
        this.genre = b.genre;
        this.artist = b.artist;
        this.seconds = b.seconds;
    }

    public static class Builder {
        String id;
        String title;
        String genre;
        Artist artist;
        int seconds;

        public Builder id(String v) { this.id = v; return this; }
        public Builder title(String v) { this.title = v; return this; }
        public Builder genre(String v) { this.genre = v; return this; }
        public Builder artist(Artist v) { this.artist = v; return this; }
        public Builder seconds(int v) { this.seconds = v; return this; }

        public Track build() { return new Track(this); }
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public Artist getArtist() { return artist; }
    public int getSeconds() { return seconds; }
}

