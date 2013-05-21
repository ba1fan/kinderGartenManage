package com.kindergarten.manage.po;

import java.sql.Timestamp;

public class UserLog {
	private int userLogId;
	private int userId;
	private Timestamp addTime;
	private int status;

	public int getUserLogId() {
		return userLogId;
	}

	public void setUserLogId(int userLogId) {
		this.userLogId = userLogId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
