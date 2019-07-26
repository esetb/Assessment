/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.helpers.Input;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Developer.Level;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Name;


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
		this.developer = new Developer(idNum, new Name("","",""), 0, null, null
				, Level.ONE);
		super.setEmployee((Employee) developer); 
		inputTitle();
		inputFirstName();
		inputLastName();
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
		
		boolean exitMenu = false;
		int menuOption = 0;
		
		do {
			displayEditEmployeeMenu();
			System.out.print(
					"\n7. Level: " + developer.getLevel().toString()
					+ "\n8. Done (return to main menu): "
					);
			menuOption = Input.getInteger("Please enter a menu option #: ", 1, 8);
			switch (menuOption) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				editEmployeeData(menuOption);
				break;
			case 7:
				inputLevel();
				break;
			case 8:
				exitMenu = true;
			}
		} while (!exitMenu);
	}
	
	/**
	 * 
	 */
	protected void displayEditMenu() {
		displayEditEmployeeMenu();
		System.out.print(
				"\n7. Level: " + developer.getLevel().toString()
				+ "\n8. Done (return to main menu): "
				);
		
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
