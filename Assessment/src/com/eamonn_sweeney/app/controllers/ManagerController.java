/**
 * 
 */
package com.eamonn_sweeney.app.controllers;

import com.eamonn_sweeney.app.models.Manager;

/**
 * @author Eamonn A. Sweeney
 *
 */
public class ManagerController extends EmployeeController {
	
	private int numStaff;
	private double salary;
	private double bonus;

	public Manager createNewManager(int idNum) {
		return new Manager(idNum, name, deptIdNum, dateStarted, phoneNum
				, numStaff, salary, bonus);
	}
	
	/**
	 * 
	 */
	public void inputData() {
		super.inputData();
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
