package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.Educate;

@Component
public interface IEducateDAO {
	/*
	 * 增删查改操作
	 */
	List<Educate> getEducates(Educate args);

	void insert(Educate model);

	void update(Educate model);

	Educate getEducate(int educateId);

	void delete(int educateId);
}
