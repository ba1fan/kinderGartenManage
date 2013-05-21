package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.Attendance;

@Component
public interface IAttendanceDAO {
	List<Attendance> getAttendances(Attendance args);

	void insert(Attendance model);

	void update(Attendance model);

	Attendance getAttendance(int attendId);

	void delete(int attendId);

}
