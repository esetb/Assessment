package com.eamonn_sweeney;

import java.time.LocalDate;

public class Manager extends Employee {
	private int numStaff;
	private double salary;
	private double bonus;



	/**
	 * @param uID
	 * @param name
	 * @param dept
	 * @param dateStarted
	 * @param phoneNum
	 * @param monthlyPay
	 */
	public Manager(int uID, Name name, Department dept, LocalDate dateStarted, 
			String phoneNum, double monthlyPay) {
		
		
	}

	/**
	 * @return the numStaff
	 */
	public int getNumStaff() {
		return numStaff;
	}

	/**
	 * @param numStaff the numStaff to set
	 */
	public void setNumStaff(int numStaff) {
		this.numStaff = numStaff;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the bonus
	 */
	public double getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
}
