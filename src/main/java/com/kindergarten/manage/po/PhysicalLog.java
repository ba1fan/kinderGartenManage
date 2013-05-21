package com.kindergarten.manage.po;

import java.sql.Timestamp;

public class PhysicalLog {
	private int logId;
	private int childId;
	private int year;
	private int term;
	private float height;
	private float weight;
	private String heightPoint;
	private String weightPoint;
	private Timestamp addTime;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
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

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getHeightPoint() {
		return heightPoint;
	}

	public void setHeightPoint(String heightPoint) {
		this.heightPoint = heightPoint;
	}

	public String getWeightPoint() {
		return weightPoint;
	}

	public void setWeightPoint(String weightPoint) {
		this.weightPoint = weightPoint;
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

	private int sex;

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

}
