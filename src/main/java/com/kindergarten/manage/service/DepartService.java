package com.kindergarten.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.IDepartDAO;
import com.kindergarten.manage.po.Depart;

@Service
public class DepartService {
	@Autowired
	private IDepartDAO departDAO;

	public List<Depart> getDeparts(Depart args) {
		return departDAO.getDeparts(args);
	}
}
