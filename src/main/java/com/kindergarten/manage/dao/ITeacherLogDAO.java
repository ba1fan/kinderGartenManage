package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.TeacherLog;

@Component
public interface ITeacherLogDAO {
	/*
	 * 增删查改操作
	 */
	List<TeacherLog> getTeacherLogs(TeacherLog args);

	void insert(TeacherLog model);

	TeacherLog getTeacherLog(int logId);

	List<TeacherLog> getTeacherDepartLogs(TeacherLog args);

	List<TeacherLog> getTeacherEducateLogs(TeacherLog args);

	List<TeacherLog> getTeacherTitleLogs(TeacherLog args);

}
