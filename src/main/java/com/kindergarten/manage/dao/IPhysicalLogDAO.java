package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.PhysicalLog;

@Component
public interface IPhysicalLogDAO {
	List<PhysicalLog> getPhysicalLogs(PhysicalLog args);

	void insert(PhysicalLog model);
}
