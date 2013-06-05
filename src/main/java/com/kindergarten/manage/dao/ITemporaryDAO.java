package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.Temporary;

@Component
public interface ITemporaryDAO {
	List<Temporary> getTemporarys(Temporary args);

	void insert(Temporary model);

	void update(Temporary model);

	Temporary getTemporary(int temporaryId);

	void delete(int temporaryId);
}
