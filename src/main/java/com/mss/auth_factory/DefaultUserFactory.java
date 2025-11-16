package com.mss.auth_factory;

import java.util.UUID;

public class DefaultUserFactory implements UserFactory {
    @Override
    public User create(String name, UserTier tier) {
        String id = UUID.randomUUID().toString();
        if (tier == UserTier.PREMIUM) {
            return new PremiumUser(id, name);
        }
        return new FreeUser(id, name);
    }
}

