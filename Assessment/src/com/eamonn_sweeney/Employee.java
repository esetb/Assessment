package com.eamonn_sweeney;

import java.time.LocalDate;

public abstract class Employee {
	protected int uID;
	protected Name name;
	protected Department dept;
	protected LocalDate dateStarted;
	protected String phoneNum;
	protected double monthlyPay;
	
	
	/**
	 * @param uID
	 * @param name
	 * @param dept
	 * @param dateStarted
	 * @param phoneNum
	 * @param monthlyPay
	 */
	protected Employee(int uID, Name name, Department dept, LocalDate dateStarted, 
			String phoneNum, double monthlyPay) {
		this.uID = uID;
		this.name = name;
		this.dept = dept;
		this.dateStarted = dateStarted;
		this.phoneNum = phoneNum;
		this.monthlyPay = monthlyPay;
	}

	/**
	 * @return the name
	 */
	protected Name getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	protected void setName(Name name) {
		this.name = name;
	}
	
	/**
	 * @return the dept
	 */
	protected Department getDept() {
		return dept;
	}
	
	/**
	 * @param dept the dept to set
	 */
	protected void setDept(Department dept) {
		this.dept = dept;
	}
	
	/**
	 * @return the dateStarted
	 */
	public LocalDate getDateStarted() {
		return dateStarted;
	}
	
	/**
	 * @param dateStarted the dateStarted to set
	 */
	protected void setDateStarted(LocalDate dateStarted) {
		this.dateStarted = dateStarted;
	}
	
	/**
	 * @return the phoneNum
	 */
	protected String getPhoneNum() {
		return phoneNum;
	}
	
	/**
	 * @param phoneNum the phoneNum to set
	 */
	protected void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	/**
	 * @return the monthlyPay
	 */
	protected double getMonthlyPay() {
		return monthlyPay;
	}
	
	/**
	 * @param monthlyPay the monthlyPay to set
	 */
	protected void setMonthlyPay(double monthlyPay) {
		this.monthlyPay = monthlyPay;
	}
	
	/**
	 * @return the uID
	 */
	protected int getuID() {
		return uID;
	}
	
}
