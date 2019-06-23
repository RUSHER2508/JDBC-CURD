package com.dev.services;

import com.dev.beans.User;
import com.dev.dao.JDBC;
import com.dev.dao.JDBCImpl;

public class ServicesImpl implements Services {

	JDBC dao=new JDBCImpl();

	@Override
	public boolean createProfile(User user) {
		
		return dao.createProfile(user);
	}

	@Override
	public User showProfile() {
		return dao.showProfile();
	}

	@Override
	public boolean updateProfile(User user) {
		return dao.updateProfile(user);
	}

	@Override
	public boolean deleteProfile(User user) {
		return dao.deleteProfile(user);
	}

	}
