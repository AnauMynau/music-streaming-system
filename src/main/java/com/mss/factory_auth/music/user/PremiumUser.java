package com.mss.factory_auth.music.user;

public class PremiumUser extends User {
    public PremiumUser(String id, String name) {
        super(id, name, UserTier.PREMIUM);
    }
}

