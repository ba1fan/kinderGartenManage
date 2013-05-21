package com.kindergarten.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.IAuthMapDAO;
import com.kindergarten.manage.po.AuthMap;

@Service
public class AuthService {
	@Autowired
	private IAuthMapDAO authMapDAO;

	public void insert(AuthMap model) {
		if (model.getAuthMapId() == 0) {
			authMapDAO.insert(model);
		} else {
			authMapDAO.update(model);
		}
	}

	public AuthMap getAuthMapByDepartId(int departId) {
		AuthMap model = authMapDAO.getAuthMapByDepartId(departId);
		if (model == null) {
			return new AuthMap();
		}
		return model;
	}
}
