package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.models.Menu;


/**
 * The Class MainMenuController.
 */
public class MainMenuController {
	
	/** The human resource controller. */
	private HumanResourceController humanResourceController;
		
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
		this.humanResourceController = new HumanResourceController(dataController, inputController);
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
				humanResourceController.listDepartments();
				break;
			case 2:
				humanResourceController.listEmployeesByDepartmentId();
				break;
			case 3:
				humanResourceController.listEmployees();
				break;
			case 4:
				humanResourceController.listManagers();
				break;
			case 5:
				humanResourceController.listDevelopers();
				break;
			case 6:
				humanResourceController.addEmployee();
				break;
			case 7:
				humanResourceController.editEmployeeById();
				break;
			case 8:
				humanResourceController.deleteEmployeeById();
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
