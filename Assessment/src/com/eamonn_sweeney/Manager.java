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
	 * @param numStaff
	 * @param salary
	 * @param bonus
	 */
	public Manager(int uID, Name name, Department dept, LocalDate dateStarted, String phoneNum, double monthlyPay,
			int numStaff, double salary, double bonus) {
		super(uID, name, dept, dateStarted, phoneNum, monthlyPay);
		this.numStaff = numStaff;
		this.salary = salary;
		this.bonus = bonus;
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
