package com.dev.services;

import com.dev.beans.User;

public interface Services {
public boolean createProfile(User user);
User showProfile();
boolean updateProfile(User user);
boolean deleteProfile(User user);
}
