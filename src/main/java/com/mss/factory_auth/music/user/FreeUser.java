package com.mss.factory_auth.music.user;

public class FreeUser extends User {
    public FreeUser(String id, String name) {
        super(id, name, UserTier.FREE);
    }
}
