package com.mss.factory_auth.music.user;

import com.mss.observer_notify.music.events.Event;
import com.mss.observer_notify.music.core.Subscriber;

public abstract class User implements Subscriber {
    protected final String id;
    protected final String name;
    protected final UserTier tier;

    public User(String id, String name, UserTier tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public UserTier getTier() { return tier; }

    @Override
    public void on(Event e) {
        System.out.println("[Notify] to " + name + ": " + e.summary());
    }
}

