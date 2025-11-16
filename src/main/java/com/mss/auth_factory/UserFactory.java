package com.mss.auth_factory;

public interface UserFactory {
    User create(String name, UserTier tier);
}

