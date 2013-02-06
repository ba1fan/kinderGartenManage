package com.kindergarten.manage.po;

public class Depart {
	// 主键I
	private int departId = 0;
	// 部门名称
	private String departName;
	// 部门状态
	private int status;

	public int getDepartId() {
		return departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
