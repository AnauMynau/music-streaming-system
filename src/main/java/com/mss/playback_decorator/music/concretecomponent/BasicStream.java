package com.mss.playback_decorator.music.concretecomponent;

import com.mss.catalog_builder.Track;
import com.mss.playback_decorator.music.component.TrackStream;

public class BasicStream implements TrackStream {
    private final Track track;

    public BasicStream(Track track) {
        this.track = track;
    }

    @Override
    public String readChunk() {
        return "♪ chunk from " + track.getTitle();
    }

    @Override
    public String info() {
        return "Basic stream";
    }
}

