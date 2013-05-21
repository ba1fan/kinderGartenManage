package com.kindergarten.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.IPhyParameterDAO;
import com.kindergarten.manage.po.PhyParameter;

@Service
public class PhyParameterService {

	@Autowired
	private IPhyParameterDAO parameterDAO;

	public List<PhyParameter> getPhyParameters(PhyParameter args) {
		return parameterDAO.getPhyParameters(args);
	}

}
