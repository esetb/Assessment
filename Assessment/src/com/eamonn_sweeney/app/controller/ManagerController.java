/**
 * 
 */
package com.eamonn_sweeney.app.controller;

/**
 * @author Eamonn A. Sweeney
 *
 */
public class ManagerController {
	
	InputController input;
	private int numStaff;
	private double salary;
	private double bonus;
	
	/**
	 * 
	 * @param input
	 */
	public ManagerController(InputController input) {
		this.input = input;
	}

	/**
	 * 
	 */
	public void inputData() {
		inputNumStaff();
		inputSalary();
		inputBonus();
	}

	/**
	 * 
	 */
	public void inputNumStaff() {
	
	}
	
	/**
	 * 
	 */
	public void inputSalary() {
	
	}
	
	/**
	 * 
	 */
	public void inputBonus() {
	
	}

	/**
	 * @return the numStaff
	 */
	public int getNumStaff() {
		return numStaff;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @return the bonus
	 */
	public double getBonus() {
		return bonus;
	}
	
}
