/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Developer.Level;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Menu;
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
	public DeveloperController(ArrayList<Department> departments, int maxDeptIdNum, 
			InputController inputController) {
		super(departments, maxDeptIdNum, inputController);
	}
	
	
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
		super.setEmployee(employee);
		this.developer = (Developer) employee;
		boolean exitMenu = false;
		int menuOption = 0;
		
		do {
			String menuTitle = "Edit Developer Menu";
			String[] menuItems = {
					"Title: " + developer.getName().getTitle(),
					"First Name: " + developer.getName().getFirstName(),
					"Last Name: " + developer.getName().getLastName(),
					"Dept ID #: " + developer.getDeptIdNum(),
					"Date Started: " + developer.getDateStarted().toString(),
					"Phone #: " + developer.getPhoneNum(),
					"Level: " + developer.getLevel(),
					"Done (return to main menu)"
					};
			Menu menu = new Menu(inputController, menuTitle, menuItems);
			menu.display();
			menuOption = menu.getOption();
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
	private void inputLevel() {
		int max = Level.values().length;
		int level = inputController.getInteger("Dev level (1-" + max + "): ", 1, max);
		this.developer.setLevel(Level.values()[level - 1]);
	}
	
}
