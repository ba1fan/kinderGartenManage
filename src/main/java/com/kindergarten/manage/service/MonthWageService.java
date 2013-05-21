package com.kindergarten.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.IAttendanceDAO;
import com.kindergarten.manage.dao.IChildDAO;
import com.kindergarten.manage.dao.IMonthWageDAO;
import com.kindergarten.manage.po.Attendance;
import com.kindergarten.manage.po.Child;
import com.kindergarten.manage.po.MonthWage;
import com.kindergarten.manage.util.WageConstants;

@Service
public class MonthWageService {

	@Autowired
	private IMonthWageDAO monthWageDAO;
	@Autowired
	private IAttendanceDAO attendanceDAO;
	@Autowired
	private IChildDAO childDAO;

	/**
	 * 根据搜索条件来获取列表
	 * 
	 * @param args
	 * @return 类json的字符串
	 */
	public String getMonthWages(MonthWage args) {
		List<MonthWage> monthWages = monthWageDAO.getMonthWages(args);
		StringBuilder sb = new StringBuilder();
		sb.append("{ Rows: [");
		if (monthWages.size() > 0) {
			for (MonthWage monthWage : monthWages) {
				sb.append("{\"monthWageId\": \"").append(monthWage.getMonthWageId()).append("\",");
				sb.append("\"childName\": \"").append(monthWage.getChildName()).append("\",");
				sb.append("\"time\": \"").append(monthWage.getYear() + "-" + monthWage.getMonth()).append("\",");
				sb.append("\"boardWages\": \"").append(monthWage.getBoardWages()).append("\",");
				sb.append("\"skillWages\": \"").append(monthWage.getSkillWages()).append("\",");
				sb.append("\"arrears\": \"").append(monthWage.getArrears()).append("\",");
				sb.append("\"careWages\": \"").append(monthWage.getCareWages()).append("\",");
				sb.append("\"manageWages\": \"").append(monthWage.getManageWages()).append("\",");
				sb.append("\"overdue\": \"").append(monthWage.getOverdue()).append("\",");
				sb.append("\"other\": \"").append(monthWage.getOther()).append("\",");
				sb.append("\"totalWages\": \"").append(monthWage.getTotalWages()).append("\",");
				sb.append("\"payWages\": \"").append(monthWage.getPayWages()).append("\"},");
			}
			sb.substring(0, sb.length());
		}
		sb.append("], Total: ").append(monthWages.size()).append(" }");
		return sb.toString();
	}

	public MonthWage initMonthWage(int childId, int year, int month) {
		MonthWage monthWage = new MonthWage();
		initInfo(monthWage);
		initInfoAttendance(monthWage, childId, year, month);
		return monthWage;
	}

	private void initInfo(MonthWage monthWage) {
		monthWage.setManageWages(WageConstants.MANAGE_WAGE);
		monthWage.setBoardWages(WageConstants.M_BOARD_WAGE);
		monthWage.setOverdue(WageConstants.ZERO_WAGE);
	}

	private void initInfoAttendance(MonthWage monthWage, int childId, int year, int month) {
		Attendance args = new Attendance();
		args.setChildId(childId);
		args.setMonth(month);
		args.setYear(year);
		List<Attendance> attendances = attendanceDAO.getAttendances(args);
		Child child = childDAO.getChild(childId);
		if (attendances.size() == 0) {
			monthWage.setMsg("请添加考勤记录");
			monthWage.setError(1);
		} else {
			args = attendances.get(0);
			if (child.getIsGrandTeahcher() == 0) {
				monthWage.setCareWages(WageConstants.CARE_WAGE * getParam(args));
			} else {
				monthWage.setCareWages(WageConstants.UNCARE_WAGE * getParam(args));
			}
		}
	}

	private float getParam(Attendance args) {
		if (args.getCount() > 12) {
			return 0;
		}
		if (args.getCount() <= 11 && args.getCount() > 0) {
			return (float) 0.5;
		}
		return 1;

	}

	public void save(MonthWage monthWage) {
		monthWage
				.setTotalWages(monthWage.getBoardWages() + monthWage.getSkillWages() + monthWage.getArrears()
						+ monthWage.getCareWages() + monthWage.getManageWages() + monthWage.getOther()
						+ monthWage.getOverdue());
		monthWageDAO.insert(monthWage);
	}
}
