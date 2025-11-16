package com.mss.auth_factory;

public class FreeUser extends User {
    public FreeUser(String id, String name) {
        super(id, name, UserTier.FREE);
    }
}
