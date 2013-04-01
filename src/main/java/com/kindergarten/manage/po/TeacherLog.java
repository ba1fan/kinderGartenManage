package com.kindergarten.manage.po;

import java.sql.Timestamp;

public class TeacherLog {
	private int logId;
	private int logType;
	private int resFromId;
	private int resToId;
	private int teacherId;
	private Timestamp addTime;

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public int getLogType() {
		return logType;
	}

	public void setLogType(int logType) {
		this.logType = logType;
	}

	public int getResFromId() {
		return resFromId;
	}

	public void setResFromId(int resFromId) {
		this.resFromId = resFromId;
	}

	public int getResToId() {
		return resToId;
	}

	public void setResToId(int resToId) {
		this.resToId = resToId;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	/**
	 * 自己添加属性
	 */
	private String fromDepartName;
	private String toDepartName;
	private String fromEducateName;
	private String toEducateName;
	private String fromTitleName;
	private String toTitleName;

	public String getFromDepartName() {
		return fromDepartName;
	}

	public void setFromDepartName(String fromDepartName) {
		this.fromDepartName = fromDepartName;
	}

	public String getToDepartName() {
		return toDepartName;
	}

	public void setToDepartName(String toDepartName) {
		this.toDepartName = toDepartName;
	}

	public String getFromEducateName() {
		return fromEducateName;
	}

	public void setFromEducateName(String fromEducateName) {
		this.fromEducateName = fromEducateName;
	}

	public String getToEducateName() {
		return toEducateName;
	}

	public void setToEducateName(String toEducateName) {
		this.toEducateName = toEducateName;
	}

	public String getFromTitleName() {
		return fromTitleName;
	}

	public void setFromTitleName(String fromTitleName) {
		this.fromTitleName = fromTitleName;
	}

	public String getToTitleName() {
		return toTitleName;
	}

	public void setToTitleName(String toTitleName) {
		this.toTitleName = toTitleName;
	}

}
