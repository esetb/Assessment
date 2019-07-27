/**
 * ApplicationController
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.models.Menu;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class ApplicationController {
	
	private EmployeesController employeeController;
	private DepartmentsController departmentController;	
	
	/**
	 * 
	 */
	public ApplicationController() {
		this.employeeController = new EmployeesController();
		this.departmentController = new DepartmentsController();
	}
	
	/**
	 * 
	 */
	public void run() {
		displayMenu();
		saveData();
	}	
	
	/* 
	 * The main menu as presented in the assessment brief has too many concerns 
	 * and out of sequence items (Department items between Employee items etc)
	 * 
	 * I have split the main menu to separate its concerns into sub menus in the
	 * Employee and Department Controllers.
	 */

	/**
	 * 
	 */
	private void displayMenu() {
		String menuTitle = "Main Menu";
		String[] menuItems = {
				"Manage Departments", 
				"Manage Employees", 
				"Show Help", 
				"Exit Program"
				};
		Menu menu = new Menu(menuTitle, menuItems);
		boolean exitMenu = false;
		
		do {
			menu.display();
			switch (menu.getOption()) {
			case 1:
				departmentController.displayMenu();
				break;
			case 2:
				employeeController.displayMenu();
			case 3:
				// show help - main menu
				break;
			case 4:
				exitMenu = true;
			}
		} while (!exitMenu);
		
		System.out.println("Goodbye!");
	}
	
	/**
	 * 
	 */
	private void saveData() {
		employeeController.saveData();
		departmentController.saveData();
	}
	
}
