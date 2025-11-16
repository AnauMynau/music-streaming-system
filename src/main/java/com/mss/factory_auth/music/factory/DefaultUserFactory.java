package com.mss.factory_auth.music.factory;

import com.mss.factory_auth.music.user.FreeUser;
import com.mss.factory_auth.music.user.PremiumUser;
import com.mss.factory_auth.music.user.User;
import com.mss.factory_auth.music.user.UserTier;

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

