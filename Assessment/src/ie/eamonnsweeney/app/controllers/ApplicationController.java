/**
 * ApplicationController
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.helpers.Input;
import ie.eamonnsweeney.app.views.Menu;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class ApplicationController {
	
	private EmployeesController empCtrl;
	private DepartmentsController deptCtrl;
	private int menuOption = 0;
	
	/**
	 * 
	 */
	public ApplicationController() {
		this.empCtrl = new EmployeesController();
		this.deptCtrl = new DepartmentsController();
	}
	
	/**
	 * 
	 */
	public void run() {
		this.mainMenu();
		this.saveData();
	}	
	
	/**
	 * 
	 */
	private void mainMenu() {
		boolean exitMenu = false;
		
		do {
			Menu.displayMain();
			menuOption = Input.getInteger("Please enter a menu option #: ", 1, 10);
			switch (menuOption) {
			case 1:
				empCtrl.listAll();
				break;
			case 2:
				empCtrl.addNew();
				break;
			case 3:
				empCtrl.editById();
				break;
			case 4:
				empCtrl.deleteById();
				break;
			case 5:
				empCtrl.listAllManagers();
				break;
			case 6:
				empCtrl.listAllDevelopers();
				break;
			case 7:
				//viewNumStaffInDepartment();
				break;
			case 8:
				//doSubMenuHolidayBooking();
				break;
			case 9:
				//doSubMenuPayment();
				break;
			case 10:
				exitMenu = true;
			default:
				break;
			}
		} while (!exitMenu);
		
		System.out.println("Goodbye!");
	}
	
	/**
	 * 
	 */
	private void saveData() {
		empCtrl.saveData();
	}
	
}
