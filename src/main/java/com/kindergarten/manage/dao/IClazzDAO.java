package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.Clazz;

@Component
public interface IClazzDAO {
	/*
	 * 增删查改操作
	 */
	List<Clazz> getClazzs(Clazz args);

	void insert(Clazz model);

	void update(Clazz model);

	Clazz getClazz(int clazzId);

	void delete(int clazzId);
}
