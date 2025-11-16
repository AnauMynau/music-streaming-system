package com.mss.decorator_playback.music.decorator;

import com.mss.decorator_playback.music.component.TrackStream;

public class HdAudioDecorator extends StreamDecorator {
    public HdAudioDecorator(TrackStream inner) {
        super(inner);
    }

    @Override
    public String readChunk() {
        return super.readChunk() + " [HD]";
    }

    @Override
    public String info() {
        return super.info() + " + HD";
    }
}
