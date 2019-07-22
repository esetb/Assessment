/**
 * 
 */
package com.eamonn_sweeney.app.controller;

import java.time.LocalDate;

import com.eamonn_sweeney.app.model.Name;

/**
 * @author Eamonn A. Sweeney
 *
 */
public class EmployeeController {

	private InputController input;
	private Name name;
	private int deptIdNum; 
	private LocalDate dateStarted;
	private String phoneNum;
	
	/**
	 * 
	 * @param input
	 */
	public EmployeeController(InputController input) {
		this.input = input;
	}

	/**
	 * 
	 */
	public void inputData() {
		inputName();
		inputDeptIdNum();
		inputDateStarted();
		inputPhoneNum();
	}

	/**
	 * 
	 */
	private void inputName() {
		
		
	}

	/**
	 * 
	 */
	private void inputDeptIdNum() {
		
		
	}
	
	/**
	 * 
	 */
	private void inputDateStarted() {
		
		
	}
	
	/**
	 * 
	 */
	private void inputPhoneNum() {
		
		
	}
	
	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * @return the deptIdNum
	 */
	public int getDeptIdNum() {
		return deptIdNum;
	}

	/**
	 * @return the dateStarted
	 */
	public LocalDate getDateStarted() {
		return dateStarted;
	}

	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

}
