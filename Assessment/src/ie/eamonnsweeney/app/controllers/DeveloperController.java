/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.helpers.Input;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Developer.Level;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class DeveloperController extends EmployeeController {
	
	private Developer developer;
	
	/**
	 * 
	 */
	public Developer createNewDeveloper(int idNum) {
		this.developer = new Developer(idNum, null, 0, null, null, null);
		super.setEmployee((Employee) developer); 
		inputName();
		inputDeptIdNum();
		inputDateStarted();
		inputPhoneNum();
		inputLevel();
		return developer;
	}

	/**
	 * 
	 */
	public void edit(Employee employee) {
		this.developer = (Developer) employee;
		super.setEmployee(employee);
		
	}
	
	/**
	 * 
	 */
	private void inputLevel() {
		int max = Level.values().length;
		int level = Input.getInteger("Dev level (1-" + max + "): ", 1, max);
		this.developer.setLevel(Level.values()[level - 1]);
	}
	
}
