/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.models.Developer;

/**
 * @author Eamonn A. Sweeney
 *
 */
public class DeveloperController extends EmployeeController {
	
	private Developer.Level level;

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
		this.inputLevel();
	}

	/**
	 * 
	 */
	public void inputLevel() {
		
	}

	/**
	 * @return the level
	 */
	public Developer.Level getLevel() {
		return this.level;
	}
	
}
