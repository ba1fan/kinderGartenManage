package com.kindergarten.manage.dao;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.Auth;

@Component
public interface IAuthDAO {
	Auth getAuthByAuthMap(int authStr);
}
