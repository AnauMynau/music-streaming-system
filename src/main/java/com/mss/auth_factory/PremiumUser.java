package com.mss.auth_factory;

public class PremiumUser extends User {
    public PremiumUser(String id, String name) {
        super(id, name, UserTier.PREMIUM);
    }
}

