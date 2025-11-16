package com.mss.decorator_playback.music.concretecomponent;

import com.mss.builder_catalog.Track;
import com.mss.decorator_playback.music.component.TrackStream;

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

