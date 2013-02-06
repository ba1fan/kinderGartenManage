package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.Depart;

@Component
public interface IDepartDAO {
	/*
	 * 增删查改操作
	 */
	List<Depart> getDeparts(Depart args);

	void insert(Depart model);

	void update(Depart model);

	Depart getDepart(int departId);

	void delete(int departId);
}
