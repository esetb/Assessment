/**
 * 
 */
package com.eamonn_sweeney.app.controllers;

import com.eamonn_sweeney.app.models.Developer;
import com.eamonn_sweeney.app.models.Developer.Level;

/**
 * @author Eamonn A. Sweeney
 *
 */
public class DeveloperController extends EmployeeController {
	
	private Level level;

	/**
	 *
	 */
	public Developer createNewDeveloper(int idNum) {
		return new Developer(idNum, name, deptIdNum, dateStarted, phoneNum
				, level);
	}
	
	/**
	 * 
	 */
	public void inputData() {
		super.inputData();
		inputLevel();
	}

	/**
	 * 
	 */
	public void inputLevel() {
		
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}
	
}
