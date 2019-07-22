/**
 * 
 */
package com.eamonn_sweeney.app.controllers;

import java.time.LocalDate;

import com.eamonn_sweeney.app.models.Name;

/**
 * @author Eamonn A. Sweeney
 *
 */
public abstract class EmployeeController {

	protected Name name;
	protected int deptIdNum; 
	protected LocalDate dateStarted;
	protected String phoneNum;

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
	public void inputName() {
			
	}

	/**
	 * 
	 */
	public void inputDeptIdNum() {
			
	}
	
	/**
	 * 
	 */
	public void inputDateStarted() {
			
	}
	
	/**
	 * 
	 */
	public void inputPhoneNum() {
			
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
