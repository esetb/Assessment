/**
 * ApplicationController
 */
package com.eamonn_sweeney.app.controllers;

import com.eamonn_sweeney.app.helpers.Input;
import com.eamonn_sweeney.app.views.Menu;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class ApplicationController {
	
	private EmployeesController empCtrl;
	private DepartmentsController departmentsController;

	private int menuOption = 0;
	
	/**
	 * 
	 */
	public ApplicationController() {
		this.empCtrl = new EmployeesController();
	}
	
	/**
	 * 
	 */
	public void run() {
		mainMenu();
		saveData();
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
