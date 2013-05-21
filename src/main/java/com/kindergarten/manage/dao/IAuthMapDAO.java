package com.kindergarten.manage.dao;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.AuthMap;

@Component
public interface IAuthMapDAO {
	void insert(AuthMap model);

	void update(AuthMap model);

	AuthMap getAuthMapByDepartId(int departId);
}
