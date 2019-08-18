package ie.eamonnsweeney.app.views;

import ie.eamonnsweeney.app.controllers.DepartmentsController;
import ie.eamonnsweeney.app.controllers.EmployeesController;
import ie.eamonnsweeney.app.controllers.InputController;
import ie.eamonnsweeney.app.models.Menu;

public class MainMenuView {
	
	private DepartmentsController departmentsController;
	private EmployeesController employeesController;
	private InputController inputController;
	private String help;
	
	public MainMenuView(DepartmentsController departmentsController, 
			EmployeesController employeesController,
			InputController inputController, 
			String help) {
		this.departmentsController = departmentsController;
		this.employeesController = employeesController;
		this.inputController = inputController;
		this.help = help;
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
