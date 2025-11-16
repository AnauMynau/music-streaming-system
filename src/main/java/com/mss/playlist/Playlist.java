package com.mss.playlist;


import com.mss.catalog_builder.Track;

import java.util.ArrayList;
import java.util.List;


public class Playlist {
    private final String id, name;
    private final List<Track> tracks;


    private Playlist(Builder b) {
        this.id = b.id; this.name = b.name; this.tracks = List.copyOf(b.tracks);
    }


    public static class Builder {
        String id, name; List<Track> tracks = new ArrayList<>();
        public Builder id(String v){ this.id=v; return this; }
        public Builder name(String v){ this.name=v; return this; }
        public Builder add(Track t){ this.tracks.add(t); return this; }
        public Playlist build(){ return new Playlist(this); }
    }


    public String getId(){ return id; }
    public String getName(){ return name; }
    public List<Track> getTracks(){ return tracks; }
}