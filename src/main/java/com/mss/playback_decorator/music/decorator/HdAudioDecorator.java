package com.mss.playback_decorator.music.decorator;

import com.mss.playback_decorator.music.component.TrackStream;

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
