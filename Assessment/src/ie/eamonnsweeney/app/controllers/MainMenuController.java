package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.models.Menu;

public class MainMenuController {
	
	private DepartmentsController departmentsController;
	private EmployeesController employeesController;
	private InputController inputController;
	private String help;
	
	public MainMenuController(
			DepartmentsController departmentsController, 
			EmployeesController employeesController,
			String help,
			InputController inputController
			) {
		this.departmentsController = departmentsController;
		this.employeesController = employeesController;
		this.help = help;
		this.inputController = inputController;
	}
	
	/**
	 * Display the main menu.
	 */
	public void display() {
		String menuTitle = "Main Menu";
		String[] menuItems = {
				"List Departments",
				"View Department",
				"List Employees", 
				"List Managers",
				"List Developers",
				"Add Employee",
				"Edit Employee",
				"Delete Employee",
				"Payment",
				"Show Help", 
				"Exit Program"
				};
		Menu menu = new Menu(inputController, menuTitle, menuItems);
		boolean exitMenu = false;
		
		do {
			menu.display();
			switch (menu.getOption()) {
			case 1:
				departmentsController.listDepartments();
				break;
			case 2:
				departmentsController.viewDepartment();
				break;
			case 3:
				employeesController.listEmployees();
				break;
			case 4:
				employeesController.listManagers();
				break;
			case 5:
				employeesController.listDevelopers();
				break;
			case 6:
				employeesController.addEmployee();
				break;
			case 7:
				employeesController.editEmployee();
				break;
			case 8:
				employeesController.deleteEmployee();
				break;
			case 9:
				// payment();
				break;
			case 10:
				System.out.println(help);
				break;
			case 11:
				exitMenu = true;
			}
		} while (!exitMenu);
		
		System.out.println("Goodbye!");
	}
}
