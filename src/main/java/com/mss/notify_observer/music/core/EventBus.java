package com.mss.notify_observer.music.core;

import com.mss.notify_observer.music.events.Event;

import java.util.HashSet;
import java.util.Set;

public class EventBus {
    private final Set<Subscriber> subs = new HashSet<>();

    public void subscribe(Subscriber s) { subs.add(s); }
    public void unsubscribe(Subscriber s) { subs.remove(s); }

    public void publish(Event e) {
        for (Subscriber s : subs) {
            s.on(e);
        }
    }
}
