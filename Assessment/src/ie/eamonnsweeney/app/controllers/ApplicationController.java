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
	
	private InputController inputController;
	private EmployeesController employeesController;
	private DepartmentsController departmentsController;
	
	/**
	 * 
	 */
	public ApplicationController() {
		FileIOController fileIOController = new FileIOController();
		this.inputController = new InputController();
		this.employeesController = new EmployeesController(fileIOController, inputController);
		this.departmentsController = new DepartmentsController(fileIOController, inputController);
	}
	
	/**
	 * 
	 */
	public void run() {
		displayMenu();
		employeesController.storeData();
		departmentsController.storeData();
		inputController.close();
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
		Menu menu = new Menu(inputController, menuTitle, menuItems);
		boolean exitMenu = false;
		
		do {
			menu.display();
			switch (menu.getOption()) {
			case 1:
				departmentsController.displayMenu();
				break;
			case 2:
				employeesController.displayMenu();
			case 3:
				// show help - main menu
				break;
			case 4:
				exitMenu = true;
			}
		} while (!exitMenu);
		
		System.out.println("Goodbye!");
	}
	
}
