package com.mss.factory_auth.music.factory;

import com.mss.factory_auth.music.user.User;
import com.mss.factory_auth.music.user.UserTier;

public interface UserFactory {
    User create(String name, UserTier tier);
}

