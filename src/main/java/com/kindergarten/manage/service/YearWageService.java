package com.kindergarten.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.IChildDAO;
import com.kindergarten.manage.dao.IYearWageDAO;
import com.kindergarten.manage.po.Child;
import com.kindergarten.manage.po.YearWage;
import com.kindergarten.manage.util.WageConstants;

@Service
public class YearWageService {
	@Autowired
	private IYearWageDAO yearWageDAO;

	@Autowired
	private IChildDAO childDAO;

	public String getYearWages(YearWage args) {
		List<YearWage> yearWages = yearWageDAO.getYearWages(args);
		StringBuilder sb = new StringBuilder();
		sb.append("{ Rows: [");
		if (yearWages.size() > 0) {
			for (YearWage yearWage : yearWages) {
				sb.append("{\"YearWageId\": \"").append(yearWage.getYearWageId()).append("\",");
				sb.append("\"childName\": \"").append(yearWage.getChildName()).append("\",");
				sb.append("\"time\": \"")
						.append(yearWage.getYear() + "-" + (yearWage.getTerm() == 1 ? "第一学期" : "第二学期")).append("\",");
				sb.append("\"applyWages\": \"").append(yearWage.getApplyWages()).append("\",");
				sb.append("\"airWages\": \"").append(yearWage.getAirWages()).append("\",");
				sb.append("\"airCollWages\": \"").append(yearWage.getAirCollWages()).append("\",");
				sb.append("\"borrowWages\": \"").append(yearWage.getBorrowWages()).append("\",");
				sb.append("\"quiltWages\": \"").append(yearWage.getQuiltWages()).append("\",");
				sb.append("\"manageWages\": \"").append(yearWage.getManageWages()).append("\",");
				sb.append("\"careWages\": \"").append(yearWage.getCareWages()).append("\",");
				sb.append("\"manageWages\": \"").append(yearWage.getManageWages()).append("\",");
				sb.append("\"authorize\": \"").append(yearWage.getAuthorize()).append("\",");
				sb.append("\"otherWages\": \"").append(yearWage.getOtherWages()).append("\",");
				sb.append("\"overstaffs\": \"").append(yearWage.getOverstaffs()).append("\",");
				sb.append("\"cookWages\": \"").append(yearWage.getCookWages()).append("\",");
				sb.append("\"totalWages\": \"").append(yearWage.getTotalWages()).append("\",");
				sb.append("\"payWages\": \"").append(yearWage.getPayWages()).append("\"},");
			}
			sb.substring(0, sb.length());
		}
		sb.append("], Total: ").append(yearWages.size()).append(" }");
		return sb.toString();
	}

	public YearWage initYearWage(int childId) {
		YearWage args = new YearWage();
		args.setChildId(childId);
		YearWage yearWage = new YearWage();
		List<YearWage> list = yearWageDAO.getYearWages(args);
		if (list.size() > 0) {
			initOldInfo(yearWage);
		} else {
			initNewInfo(yearWage);
		}
		initInfo(yearWage, childId);
		yearWage.setTotalWages(yearWage.getApplyWages() + yearWage.getAirWages() + yearWage.getAirCollWages()
				+ yearWage.getBorrowWages() + yearWage.getQuiltWages() + yearWage.getManageWages()
				+ yearWage.getCareWages() + yearWage.getOtherWages() + yearWage.getAuthorize()
				+ yearWage.getOtherWages() + yearWage.getCookWages());
		// initOldInfo(yearWage);
		// initInfoAttendance(yearWage, childId, year, month);
		return yearWage;
	}

	private void initOldInfo(YearWage yearWage) {
		yearWage.setApplyWages(WageConstants.APPLY_OLD);
		yearWage.setAirWages(WageConstants.AIR_WAGE);
		yearWage.setAirCollWages(WageConstants.AIR_COLLECTION_OLD);
		// yearWage.setManageWages(WageConstants.MANAGE_WAGE);

	}

	private void initNewInfo(YearWage yearWage) {
		yearWage.setApplyWages(WageConstants.APPLY_NEW);
		yearWage.setAirWages(WageConstants.AIR_WAGE);
		yearWage.setAirCollWages(WageConstants.AIR_COLLECTION_NEW);

	}

	private void initInfo(YearWage yearWage, int childId) {
		yearWage.setQuiltWages(WageConstants.QUILT_WAGE);
		yearWage.setManageWages(WageConstants.MANAGE_WAGE);
		yearWage.setAuthorize(WageConstants.AUTHORIZE_WAGE);
		yearWage.setCareWages(WageConstants.CARE_WAGE * 4);
		yearWage.setOverstaffs(WageConstants.ZERO_WAGE);
		yearWage.setOtherWages(WageConstants.OTHER_WAGE);
		yearWage.setCookWages(WageConstants.COOK_WAGE);
		Child child = childDAO.getChild(childId);
		if (child.getIsGrandTeahcher() == 0) {
			yearWage.setBorrowWages(WageConstants.BORROW_WAGE_OTHER);
		} else {
			yearWage.setBorrowWages(WageConstants.BORROW_WAGE_THIRD);
		}

	}

	public void save(YearWage yearWage) {

		yearWageDAO.insert(yearWage);
	}

}
