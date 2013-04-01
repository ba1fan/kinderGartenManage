package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.TechTitle;

@Component
public interface ITechTitleDAO {
	/*
	 * 增删查改操作
	 */
	List<TechTitle> getTechTitles(TechTitle args);

	void insert(TechTitle model);

	void update(TechTitle model);

	TechTitle getTechTitle(int titleId);

	void delete(int titleId);
}
