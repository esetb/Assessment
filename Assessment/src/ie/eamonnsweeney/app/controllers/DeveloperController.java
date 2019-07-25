/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.helpers.Input;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Developer.Level;
import ie.eamonnsweeney.app.models.Employee;

/**
 * @author Eamonn A. Sweeney
 *
 */
public class DeveloperController extends EmployeeController {
	
	private Developer developer;
	
	/**
	 * 
	 */
	public DeveloperController(int idNum) {
		super((Employee) new Developer(idNum, null, 0, null, null, null));
		this.developer = (Developer) getEmployee();
	}
	
	/**
	 * 
	 */
	public DeveloperController(Employee employee) {
		super(employee);
		this.developer = (Developer) employee;
	}
	
	/**
	 * 
	 */
	public Developer createNewDeveloper() {
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
	public void edit() {
		
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
