package com.mss.notify_observer.music.core;

import com.mss.notify_observer.music.events.Event;

public interface Subscriber {
    void on(Event e);
}

