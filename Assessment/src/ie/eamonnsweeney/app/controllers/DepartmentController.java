/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Menu;


/**
 * The Class DepartmentController.
 *
 * @author Eamonn A. Sweeney
 */
public class DepartmentController {
	
	/** The department. */
	private Department department;
	
	/** The input controller. */
	private InputController inputController;
	
	/**
	 * Instantiates a new department controller.
	 *
	 * @param inputController the input controller
	 */
	public DepartmentController(InputController inputController) {
		this.inputController = inputController;
	}
	
	/**
	 * Creates the new department.
	 *
	 * @param idNum the id num
	 * @return the department
	 */
	public Department createNewDepartment(int idNum) {
		this.department = new Department(idNum, null, 0);
		inputName();
		return department;
	}
	
	/**
	 * Edits a departments data.
	 *
	 * @param department the department
	 */
	public void edit(Department department) {
		this.department = department;
		String menuTitle = "Edit Department Menu";
		String[] menuItems = {
				"Dept Name: " + department.getName(),
				"Done (return to main menu)"
				};
		Menu menu = new Menu(inputController, menuTitle, menuItems);
		boolean exitMenu = false;
		int menuOption = 0;
		
		do {
			menu.display();
			menuOption = menu.getOption();
			switch (menuOption) {
			case 1:
				inputName();
				break;
			case 2:
				exitMenu = true;
				break;
			}
		} while (!exitMenu);
	}
	
	/**
	 * Input name.
	 */
	private void inputName() {
		String name = inputController.getString("Enter new name: ");
		this.department.setName(name);
	}
	
}
