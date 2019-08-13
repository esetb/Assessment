/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Menu;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class DepartmentController {
	
	private Department department;
	private InputController inputController;
	
	/**
	 * 
	 */
	public DepartmentController(InputController inputController) {
		this.inputController = inputController;
	}
	
	/**
	 * 
	 */
	public Department createNewDepartment(int idNum) {
		this.department = new Department(idNum, null, 0);
		inputName();
		return department;
	}
	
	/**
	 * 
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
	 * 
	 */
	private void inputName() {
		String name = inputController.getString("Enter new name: ");
		this.department.setName(name);
	}
	
}
