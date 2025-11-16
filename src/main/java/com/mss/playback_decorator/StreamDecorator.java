package com.mss.playback_decorator;

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
