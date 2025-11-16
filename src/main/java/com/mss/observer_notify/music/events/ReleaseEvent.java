package com.mss.observer_notify.music.events;

import com.mss.builder_catalog.Track;

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

