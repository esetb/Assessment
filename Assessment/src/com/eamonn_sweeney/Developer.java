package com.eamonn_sweeney;

import java.time.LocalDate;

public class Developer extends Employee {
	public enum Level {
		ONE,
		TWO,
		THREE;
	}
	private Level level;
	private double hourlyRate;
	
	/**
	 * @param idNum
	 * @param name
	 * @param dept
	 * @param dateStarted
	 * @param phoneNum
	 * @param monthlyPay
	 * @param level
	 * @param hourlyRate
	 */
	public Developer(int idNum, Name name, Department dept, LocalDate dateStarted, 
			String phoneNum, double monthlyPay, Level level) {
		super(idNum, name, dept, dateStarted, phoneNum, monthlyPay);
		this.level = level;
		this.hourlyRate = 0;
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * @return the hourlyRate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * @param hourlyRate the hourlyRate to set
	 */
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
}
