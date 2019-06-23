package com.dev.dao;

import com.dev.beans.User;

public interface JDBC {

boolean createProfile(User user);
User showProfile();
boolean updateProfile(User user);
boolean deleteProfile(User user);
}
