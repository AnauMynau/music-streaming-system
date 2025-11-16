package com.mss.auth_factory.music.factory;

import com.mss.auth_factory.music.user.User;
import com.mss.auth_factory.music.user.UserTier;

public interface UserFactory {
    User create(String name, UserTier tier);
}

