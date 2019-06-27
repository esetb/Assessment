package com.eamonn_sweeney;

import java.time.LocalDate;

public class Developer extends Employee {
	private int level;
	private double hourlyRate;
	
	/**
	 * @param uID
	 * @param name
	 * @param dept
	 * @param dateStarted
	 * @param phoneNum
	 * @param monthlyPay
	 * @param level 
	 */
	public Developer(int uID, Name name, Department dept, LocalDate dateStarted, 
			String phoneNum, double monthlyPay, int level) {
		this.uID = uID;
		this.dept = dept;
		this.dateStarted = dateStarted;
		this.phoneNum = phoneNum;
		this.monthlyPay = monthlyPay;
		this.level = level;
		
	}
}
