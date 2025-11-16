package com.mss.observer_notify.music.core;

import com.mss.observer_notify.music.events.Event;

public interface Subscriber {
    void on(Event e);
}

