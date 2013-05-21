package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.Child;

@Component
public interface IChildDAO {
	List<Child> getChilds(Child args);

	void insert(Child model);

	void update(Child model);

	Child getChild(int childId);

	void delete(int childId);
}
