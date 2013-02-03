package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.Depart;

@Component
public interface IDepartDAO {
	List<Depart> getDeparts(Depart args);
}
