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
	 * @return the name
	 */
	public Name getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}
	
	/**
	 * @return the dept
	 */
	public Department getDept() {
		return dept;
	}
	
	/**
	 * @param dept the dept to set
	 */
	public void setDept(Department dept) {
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
	public void setDateStarted(LocalDate dateStarted) {
		this.dateStarted = dateStarted;
	}
	
	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	
	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	/**
	 * @return the monthlyPay
	 */
	public double getMonthlyPay() {
		return monthlyPay;
	}
	
	/**
	 * @param monthlyPay the monthlyPay to set
	 */
	public void setMonthlyPay(double monthlyPay) {
		this.monthlyPay = monthlyPay;
	}
	
	/**
	 * @return the uID
	 */
	public int getuID() {
		return uID;
	}
	
}
