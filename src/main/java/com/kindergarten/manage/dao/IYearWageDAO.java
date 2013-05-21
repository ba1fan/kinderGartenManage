package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.YearWage;

@Component
public interface IYearWageDAO {
	List<YearWage> getYearWages(YearWage args);

	void insert(YearWage model);

	void update(YearWage model);
}
