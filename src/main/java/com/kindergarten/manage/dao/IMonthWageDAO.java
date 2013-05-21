package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.MonthWage;

@Component
public interface IMonthWageDAO {
	List<MonthWage> getMonthWages(MonthWage args);

	void insert(MonthWage model);

	void update(MonthWage model);
}
