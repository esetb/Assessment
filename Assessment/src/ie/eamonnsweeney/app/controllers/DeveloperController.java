/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.helpers.Input;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Developer.Level;

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
		super.inputData();
		this.inputLevel();
		return new Developer(idNum, getName(), getDeptIdNum(), getDateStarted()
				, getPhoneNum(), this.level);
	}

	/**
	 * 
	 */
	public void inputLevel() {
		int max = Level.values().length;
		int level = Input.getInteger("Dev level (1-" + max + "): ", 1, max);
		this.level = Level.values()[level - 1];
	}
	
}
