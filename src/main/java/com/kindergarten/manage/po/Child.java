package com.kindergarten.manage.po;

import java.sql.Timestamp;

public class Child {
	private int childId;
	private String childName;
	private Timestamp birthday;
	private Timestamp entranday;
	private int clazzId;
	private String fatherName;
	private String motherName;
	private String address;
	private String tel;
	private int isTeahcher;
	private int isGrandTeahcher;
	private String fatherAge;
	private String motherAge;
	private String fatherOcu;
	private String motherOcu;
	private int sex;

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public Timestamp getEntranday() {
		return entranday;
	}

	public void setEntranday(Timestamp entranday) {
		this.entranday = entranday;
	}

	public int getClazzId() {
		return clazzId;
	}

	public void setClazzId(int clazzId) {
		this.clazzId = clazzId;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getIsTeahcher() {
		return isTeahcher;
	}

	public void setIsTeahcher(int isTeahcher) {
		this.isTeahcher = isTeahcher;
	}

	public int getIsGrandTeahcher() {
		return isGrandTeahcher;
	}

	public void setIsGrandTeahcher(int isGrandTeahcher) {
		this.isGrandTeahcher = isGrandTeahcher;
	}

	public String getFatherAge() {
		return fatherAge;
	}

	public void setFatherAge(String fatherAge) {
		this.fatherAge = fatherAge;
	}

	public String getMotherAge() {
		return motherAge;
	}

	public void setMotherAge(String motherAge) {
		this.motherAge = motherAge;
	}

	public String getFatherOcu() {
		return fatherOcu;
	}

	public void setFatherOcu(String fatherOcu) {
		this.fatherOcu = fatherOcu;
	}

	public String getMotherOcu() {
		return motherOcu;
	}

	public void setMotherOcu(String motherOcu) {
		this.motherOcu = motherOcu;
	}

	/**
	 * ×Ô¶¨Òå
	 * 
	 * @return
	 */

	private String birthdayStr;
	private String entrandayStr;

	public String getBirthdayStr() {
		return birthdayStr;
	}

	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}

	public String getEntrandayStr() {
		return entrandayStr;
	}

	public void setEntrandayStr(String entrandayStr) {
		this.entrandayStr = entrandayStr;
	}

}
