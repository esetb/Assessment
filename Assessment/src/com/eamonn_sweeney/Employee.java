package com.eamonn_sweeney;

import java.time.LocalDate;

public abstract class Employee {
	protected int idNum;
	protected Name name;
	protected Department dept;
	protected LocalDate dateStarted;
	protected String phoneNum;
	protected double monthlyPay;
	
	
	/**
	 * @param idNum
	 * @param name
	 * @param dept
	 * @param dateStarted
	 * @param phoneNum
	 * @param monthlyPay
	 */
	protected Employee(int idNum, Name name, Department dept, LocalDate dateStarted, 
			String phoneNum, double monthlyPay) {
		this.idNum = idNum;
		this.name = name;
		this.dept = dept;
		this.dateStarted = dateStarted;
		this.phoneNum = phoneNum;
		this.monthlyPay = monthlyPay;
	}

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
	public int getIdNum() {
		return idNum;
	}
	
}
