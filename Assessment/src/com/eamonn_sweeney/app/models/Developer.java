/**
 * Developer Class extends Employee
 */
package com.eamonn_sweeney.app.models;

import java.time.LocalDate;
import java.util.Objects;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class Developer extends Employee {
	
	public enum Level {
		ONE(1, 17.0),
		TWO(2, 18.0),
		THREE(3, 19.50);
		
		private final int levelNum;
		private final double hourlyRate;
		
		private Level(int levelNum, double hourlyRate) {
			this.levelNum = levelNum;
			this.hourlyRate = hourlyRate;
		}
		
		@Override
		public String toString() {
			return "" + levelNum;
		}
	}
	private Level level;
	
	/**
	 * @param name
	 * @param dept
	 * @param dateStarted
	 * @param phoneNum
	 * @param monthlyPay
	 */
	public Developer(Name name, Department dept, LocalDate dateStarted, 
			String phoneNum, double monthlyPay) {
		super(name, dept, dateStarted, phoneNum, monthlyPay);
		this.level = Level.ONE;
	}
	
	/**
	 * @param name
	 * @param dept
	 * @param dateStarted
	 * @param phoneNum
	 * @param monthlyPay
	 * @param level
	 */
	public Developer(Name name, Department dept, LocalDate dateStarted, 
			String phoneNum, double monthlyPay, Level level) {
		super(name, dept, dateStarted, phoneNum, monthlyPay);
		this.level = level;
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
		return level.hourlyRate;
	}

	@Override
	public String toString() {
		return "Developer [idNum=" + idNum 
				+ ", name=" + name
				+ ", dept=" + dept 
				+ ", dateStarted=" + dateStarted 
				+ ", phoneNum=" + phoneNum 
				+ ", monthlyPay=" + monthlyPay 
				+ ", level=" + level
				+ ", hourlyRate=" + level.hourlyRate
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(level);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Developer))
			return false;
		Developer other = (Developer) obj;
		return level == other.level;
	}
	
}
