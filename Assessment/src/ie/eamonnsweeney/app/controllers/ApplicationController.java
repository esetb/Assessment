/**
 * ApplicationController
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.helpers.Input;
import ie.eamonnsweeney.app.models.Menu;
import ie.eamonnsweeney.app.views.ConsoleView;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class ApplicationController {
	
	private EmployeesController empCtrl;
	private DepartmentsController deptCtrl;
	private ConsoleView view;
	
	
	/**
	 * 
	 */
	public ApplicationController() {
		this.empCtrl = new EmployeesController();
		this.deptCtrl = new DepartmentsController();
		this.view = new ConsoleView();
	}
	
	/**
	 * 
	 */
	public void run() {
		mainMenu();
		saveData();
	}	
	
	/* 
	 * The main menu as presented in the assessment brief has too many concerns 
	 * and out of sequence items (Department items between Employee items)
	 * 
	 * I have split the main menu to a series of sub menus in order to separate 
	 * its concerns and to provide a more logical sequence of menu items in the 
	 * sub menus.
	 */

	/**
	 * 
	 */
	private void mainMenu() {
		Menu menu = null;
		String menuTitle = "Main Menu";
		String[] menuItems = {
				"Manage Departments", 
				"Manage Employees", 
				"Show Help", 
				"Exit Program"
				};
		boolean exitMenu = false;
		int menuOption = 0;
		
		menu = (menu == null) ? new Menu(menuTitle, menuItems) : menu;

		do {
			System.out.println(menu);
			menuOption = Input.getInteger("Enter menu option #: ", 1, 4);
			switch (menuOption) {
			case 1:
				departmentsSubMenu();
				break;
			case 2:
				employeesSubMenu();
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
	private void departmentsSubMenu() {
		boolean exitMenu = false;
		int menuOption = 0;

		do {
			System.out.println("\n" 
					+ "*** Departments Menu ***"
					+ "\n1. List All"
					+ "\n2. View Department"  
					+ "\n3. Show Help"
					+ "\n4. Return to Main Menu."
					);
			menuOption = Input.getInteger("Please enter a menu option #: ", 1, 11);
			switch (menuOption) {
			case 1:
				deptCtrl.listAll();
				break;
			case 2:
				// list dept details (id name # employees/managers/developers).
			case 3:
				// show help
				break;
			case 4:
				exitMenu = true;
			}
		} while (!exitMenu);
		
	}
	
	/**
	 * 
	 */
	private void employeesSubMenu() {
		boolean exitMenu = false;
		int menuOption = 0;

		do {
			System.out.println("\n" 
					+ "*** Employees Menu ***"
					+ "\n1. List All"
					+ "\n2. List Managers" 
					+ "\n3. List Developers"
					+ "\n4. Add Employee" 
					+ "\n5. Edit Employee"
					+ "\n6. Delete Employee" 
					+ "\n7. Payment" 
					+ "\n8. Show Help"
					+ "\n9. Return to Main Menu."
					);
			menuOption = Input.getInteger("Please enter a menu option #: ", 1, 9);
			switch (menuOption) {
			case 1:
				empCtrl.listAll();
				break;
			case 2:
				empCtrl.listManagers();
			case 3:
				empCtrl.listDevelopers();
				break;
			case 4:
				empCtrl.addNew();
				break;
			case 5:
				empCtrl.editById();
				break;
			case 6:
				empCtrl.deleteById();
				break;
			case 7:
				// payment
				break;
			case 8:
				// show help - employees
				break;
			case 9:
				exitMenu = true;
				break	;
			}
		} while (!exitMenu);

	}
	
	/**
	 * 
	 */
	private void saveData() {
		empCtrl.saveData();
		deptCtrl.saveData();
	}
	
}
