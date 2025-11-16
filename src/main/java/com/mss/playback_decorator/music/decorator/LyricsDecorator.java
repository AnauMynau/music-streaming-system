package com.mss.playback_decorator.music.decorator;

import com.mss.playback_decorator.music.component.TrackStream;

public class LyricsDecorator extends StreamDecorator {
    public LyricsDecorator(TrackStream inner) {
        super(inner);
    }

    @Override
    public String readChunk() {
        return super.readChunk() + " [Lyrics overlay]";
    }

    @Override
    public String info() {
        return super.info() + " + Lyrics";
    }
}

