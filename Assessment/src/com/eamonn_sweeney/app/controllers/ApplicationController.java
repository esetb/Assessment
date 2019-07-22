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
	
	private EmployeesController employeesController;
	private DepartmentsController deptsCtrl;

	private int menuOption = 0;
	
	/**
	 * 
	 */
	public ApplicationController() {
		this.employeesController = new EmployeesController();
	}
	
	/**
	 * 
	 */
	public void run() {
		mainMenu();
		saveData();
		cleanUp();
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
				employeesController.listAll();
				break;
			case 2:
				//addNewEmployee();
				break;
			case 3:
				//editEmployeeById();
				break;
			case 4:
				//deleteEmployeeById();
				break;
			case 5:
				employeesController.listAllManagers();
				break;
			case 6:
				employeesController.listAllDevelopers();
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
		employeesController.saveData();
	}
	
	/**
	 * 
	 */
	private void cleanUp() {
		Input.close();
	}
	
}
