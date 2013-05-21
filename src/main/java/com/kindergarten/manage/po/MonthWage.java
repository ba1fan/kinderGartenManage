package com.kindergarten.manage.po;

import java.sql.Timestamp;

public class MonthWage {
	private int monthWageId;
	private int year;
	private int month;
	private int childId;
	/**
	 * 伙食费
	 */
	private float boardWages;
	/**
	 * 艺训费
	 */
	private float skillWages;
	/**
	 * 上月欠缴
	 */
	private float arrears;
	/**
	 * 保育费
	 */
	private float careWages;
	/**
	 * 管理费
	 */
	private float manageWages;
	/**
	 * 滞纳金
	 */
	private float overdue;
	/**
	 * 其他费用
	 */
	private float other;
	/**
	 * 总金额
	 */
	private float totalWages;
	/**
	 * 实际支付金额
	 */
	private float payWages;
	private Timestamp addTime;

	public int getMonthWageId() {
		return monthWageId;
	}

	public void setMonthWageId(int monthWageId) {
		this.monthWageId = monthWageId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

	public float getBoardWages() {
		return boardWages;
	}

	public void setBoardWages(float boardWages) {
		this.boardWages = boardWages;
	}

	public float getSkillWages() {
		return skillWages;
	}

	public void setSkillWages(float skillWages) {
		this.skillWages = skillWages;
	}

	public float getArrears() {
		return arrears;
	}

	public void setArrears(float arrears) {
		this.arrears = arrears;
	}

	public float getCareWages() {
		return careWages;
	}

	public void setCareWages(float careWages) {
		this.careWages = careWages;
	}

	public float getManageWages() {
		return manageWages;
	}

	public void setManageWages(float manageWages) {
		this.manageWages = manageWages;
	}

	public float getOverdue() {
		return overdue;
	}

	public void setOverdue(float overdue) {
		this.overdue = overdue;
	}

	public float getOther() {
		return other;
	}

	public void setOther(float other) {
		this.other = other;
	}

	public float getTotalWages() {
		return totalWages;
	}

	public void setTotalWages(float totalWages) {
		this.totalWages = totalWages;
	}

	public float getPayWages() {
		return payWages;
	}

	public void setPayWages(float payWages) {
		this.payWages = payWages;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	private String childName;

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private int error;

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

}
