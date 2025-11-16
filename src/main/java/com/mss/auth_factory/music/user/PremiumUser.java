package com.mss.auth_factory.music.user;

public class PremiumUser extends User {
    public PremiumUser(String id, String name) {
        super(id, name, UserTier.PREMIUM);
    }
}

