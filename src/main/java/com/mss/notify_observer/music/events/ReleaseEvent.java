package com.mss.notify_observer.music.events;

import com.mss.catalog_builder.Track;

public class ReleaseEvent extends Event {
    private final Track track;

    public ReleaseEvent(Track track) {
        this.track = track;
    }

    @Override
    public String summary() {
        return "New release: " + track.getTitle();
    }
}

