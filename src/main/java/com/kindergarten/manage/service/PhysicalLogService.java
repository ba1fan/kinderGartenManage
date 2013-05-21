package com.kindergarten.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.IChildDAO;
import com.kindergarten.manage.dao.IPhyParameterDAO;
import com.kindergarten.manage.dao.IPhysicalLogDAO;
import com.kindergarten.manage.po.Child;
import com.kindergarten.manage.po.PhyParameter;
import com.kindergarten.manage.po.PhysicalLog;
import com.kindergarten.manage.util.Constants;
import com.kindergarten.manage.util.TimeMethod;

@Service
public class PhysicalLogService {
	@Autowired
	private IPhysicalLogDAO logDAO;
	@Autowired
	private IPhyParameterDAO parameterDAO;
	@Autowired
	private IChildDAO childDAO;

	/**
	 * 根据搜索条件来获取学历的列表
	 * 
	 * @param args
	 * @return 类json的字符串
	 */
	public String getPhysicalLogs(PhysicalLog args) {
		List<PhysicalLog> physicalLogs = logDAO.getPhysicalLogs(args);
		StringBuilder sb = new StringBuilder();
		sb.append("{ Rows: [");
		if (physicalLogs.size() > 0) {
			for (PhysicalLog physicalLog : physicalLogs) {
				sb.append("{\"logId\": \"").append(physicalLog.getLogId()).append("\",");
				sb.append("\"childName\": \"").append(physicalLog.getChildName()).append("\",");
				sb.append("\"term\": \"").append(physicalLog.getTerm() == 0 ? "第一学期" : "第二学期").append("\",");
				sb.append("\"sex\": \"").append(physicalLog.getSex() == 0 ? "男" : "女").append("\",");
				sb.append("\"year\": \"").append(physicalLog.getYear()).append("\",");
				sb.append("\"height\": \"").append(physicalLog.getHeight()).append("\",");
				sb.append("\"weight\": \"").append(physicalLog.getWeight()).append("\",");
				sb.append("\"heightPoint\": \"").append(physicalLog.getHeightPoint()).append("\",");
				sb.append("\"weightPoint\": \"").append(physicalLog.getWeightPoint()).append("\"},");
			}
			sb.substring(0, sb.length());
		}
		sb.append("], Total: ").append(physicalLogs.size()).append(" }");
		return sb.toString();
	}

	public void save(PhysicalLog model) {
		Child child = childDAO.getChild(model.getChildId());
		PhyParameter args = new PhyParameter();
		args.setMonth(TimeMethod.getNowMonth() - TimeMethod.getTimestapMonth(child.getBirthday()));
		args.setYear(TimeMethod.getNowYear() - TimeMethod.getTimestapYear(child.getBirthday()));
		args.setSex(child.getSex());
		args.setPhyType(1);
		model.setWeightPoint(getPhyPoint(parameterDAO.getPhyParameters(args).get(0), model.getWeight()));
		args.setPhyType(0);
		model.setHeightPoint(getPhyPoint(parameterDAO.getPhyParameters(args).get(0), model.getHeight()));
		logDAO.insert(model);
	}

	public String getPhyPoint(PhyParameter parameter, float score) {
		if (score > parameter.getaLevel()) {
			return Constants.PARAM_A_LEVEL;
		}
		if (score > parameter.getbLevel()) {
			return Constants.PARAM_B_LEVEL;
		}
		if (score > parameter.getcLevel()) {
			return Constants.PARAM_C_LEVEL;
		}
		if (score > parameter.getdLevel()) {
			return Constants.PARAM_D_LEVEL;
		}
		if (score > parameter.geteLevel()) {
			return Constants.PARAM_E_LEVEL;
		}
		if (score > parameter.getfLevel()) {
			return Constants.PARAM_F_LEVEL;
		}
		if (score > parameter.getgLevel()) {
			return Constants.PARAM_G_LEVEL;
		}
		return Constants.PARAM_H_LEVEL;
	}
}
