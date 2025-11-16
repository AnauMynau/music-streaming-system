package com.mss.playback_decorator.music.decorator;

import com.mss.playback_decorator.music.component.TrackStream;

public abstract class StreamDecorator implements TrackStream {
    protected final TrackStream inner;

    protected StreamDecorator(TrackStream inner) {
        this.inner = inner;
    }

    @Override
    public String readChunk() {
        return inner.readChunk();
    }

    @Override
    public String info() {
        return inner.info();
    }
}
