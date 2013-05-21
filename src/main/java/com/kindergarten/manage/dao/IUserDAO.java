package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.User;

@Component
public interface IUserDAO {
	List<User> getUsers(User args);

	void insert(User model);

	void update(User model);

	User getUser(int userId);

	void delete(int userId);

	User getLoginUser(User args);
}
