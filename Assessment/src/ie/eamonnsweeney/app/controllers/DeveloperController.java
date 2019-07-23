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
		super.inputData();
		this.inputLevel();
		return new Developer(idNum, super.getName(), super.getDeptIdNum()
				, super.getDateStarted(), super.getPhoneNum()
				, this.level);
	}

	/**
	 * 
	 */
	public void inputLevel() {
		
	}
	
}
