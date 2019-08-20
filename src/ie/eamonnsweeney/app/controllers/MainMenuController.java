package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.models.Menu;


/**
 * The Class MainMenuController.
 */
public class MainMenuController {
	
	/** The departments controller. */
	private DepartmentsController departmentsController;
	
	/** The employees controller. */
	private EmployeesController employeesController;
	
	/** The input controller. */
	private InputController inputController;
	
	/** The help. */
	private String help;
	
	/**
	 * Instantiates a new main menu controller.
	 *
	 * @param dataController the data controller
	 * @param inputController the input controller
	 */
	public MainMenuController(DataController dataController, InputController inputController) {
		this.departmentsController = new DepartmentsController(dataController, inputController);
		this.employeesController = new EmployeesController(dataController, inputController);
		this.help = dataController.getHelp();
		this.inputController = inputController;
	}
	
	/**
	 * Run.
	 */
	public void run() {
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
				departmentsController.viewDepartmentbyId();
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
