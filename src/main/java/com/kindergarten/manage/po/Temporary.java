package com.kindergarten.manage.po;

import java.sql.Timestamp;

public class Temporary {
	private int temporaryId;
	private int userId;
	private int year;
	private int month;
	private float basic;
	private float award;
	private Timestamp addTime;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTemporaryId() {
		return temporaryId;
	}

	public void setTemporaryId(int temporaryId) {
		this.temporaryId = temporaryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public float getBasic() {
		return basic;
	}

	public void setBasic(float basic) {
		this.basic = basic;
	}

	public float getAward() {
		return award;
	}

	public void setAward(float award) {
		this.award = award;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}
