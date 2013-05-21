package com.kindergarten.manage.po;

import java.sql.Timestamp;

public class YearWage {
	private int yearWageId;
	private int year;
	private int term;
	private int childId;
	/**
	 * ������
	 */
	private float applyWages;
	/**
	 * �յ���
	 */
	private float airWages;
	/**
	 * �յ����ʷ�
	 */
	private float airCollWages;
	/**
	 * ��԰��
	 */
	private float borrowWages;
	/**
	 * �ⱻ��
	 */
	private float quiltWages;
	/**
	 * �����
	 */
	private float manageWages;
	/**
	 * ������
	 */
	private float careWages;
	/**
	 * �ӷ�
	 */
	private float otherWages;
	/**
	 * �����
	 */
	private float authorize;
	/**
	 * �����
	 */
	private float overstaffs;
	/**
	 * �����
	 */
	private float cookWages;
	/**
	 * �ܷ���
	 */
	private float totalWages;
	/**
	 * ʵ��֧��
	 */
	private float payWages;
	private Timestamp addTime;

	public int getYearWageId() {
		return yearWageId;
	}

	public void setYearWageId(int yearWageId) {
		this.yearWageId = yearWageId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

	public float getApplyWages() {
		return applyWages;
	}

	public void setApplyWages(float applyWages) {
		this.applyWages = applyWages;
	}

	public float getAirWages() {
		return airWages;
	}

	public void setAirWages(float airWages) {
		this.airWages = airWages;
	}

	public float getAirCollWages() {
		return airCollWages;
	}

	public void setAirCollWages(float airCollWages) {
		this.airCollWages = airCollWages;
	}

	public float getBorrowWages() {
		return borrowWages;
	}

	public void setBorrowWages(float borrowWages) {
		this.borrowWages = borrowWages;
	}

	public float getQuiltWages() {
		return quiltWages;
	}

	public void setQuiltWages(float quiltWages) {
		this.quiltWages = quiltWages;
	}

	public float getManageWages() {
		return manageWages;
	}

	public void setManageWages(float manageWages) {
		this.manageWages = manageWages;
	}

	public float getCareWages() {
		return careWages;
	}

	public void setCareWages(float careWages) {
		this.careWages = careWages;
	}

	public float getOtherWages() {
		return otherWages;
	}

	public void setOtherWages(float otherWages) {
		this.otherWages = otherWages;
	}

	public float getAuthorize() {
		return authorize;
	}

	public void setAuthorize(float authorize) {
		this.authorize = authorize;
	}

	public float getOverstaffs() {
		return overstaffs;
	}

	public void setOverstaffs(float overstaffs) {
		this.overstaffs = overstaffs;
	}

	public float getCookWages() {
		return cookWages;
	}

	public void setCookWages(float cookWages) {
		this.cookWages = cookWages;
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

}
