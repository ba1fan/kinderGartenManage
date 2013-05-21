package com.kindergarten.manage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kindergarten.manage.po.PhyParameter;

@Component
public interface IPhyParameterDAO {
	List<PhyParameter> getPhyParameters(PhyParameter args);
}
