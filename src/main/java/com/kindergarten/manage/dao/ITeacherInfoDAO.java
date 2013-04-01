package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.TeacherInfo;

@Component
public interface ITeacherInfoDAO {
	/*
	 * ��ɾ��Ĳ���
	 */
	List<TeacherInfo> getTeacherInfos(TeacherInfo args);

	void insert(TeacherInfo model);

	void update(TeacherInfo model);

	TeacherInfo getTeacherInfo(int teacherId);

	void delete(int teacherId);
}
