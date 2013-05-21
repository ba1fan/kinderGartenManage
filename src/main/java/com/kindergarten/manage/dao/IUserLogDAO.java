package com.kindergarten.manage.dao;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.UserLog;

@Component
public interface IUserLogDAO {
	// List<User> getUsers(User args);

	void insert(UserLog model);

	int getLoginErrorCount(int userId);
	//
	// void update(User model);
	//
	// User getUser(int userId);
	//
	// void delete(int userId);
	//
	// User getLoginUser(User args);
}
