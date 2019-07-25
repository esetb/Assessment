/**
 * ApplicationController
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.helpers.Input;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class ApplicationController {
	
	private EmployeesController empCtrl;
	private DepartmentsController deptCtrl;
	
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
		int menuOption = 0;
		
		do {
			System.out.println("\n" 
					+ "*** Main Menu ***"
					+ "\n1. List all Employees" 
					+ "\n2. Add a new Employee" 
					+ "\n3. Edit an Employee by id"
					+ "\n4. Delete an Employee by id" 
					+ "\n5. View all Managers" 
					+ "\n6. View all Developers"
					+ "\n7. View number of staff within a department" 
					+ "\n8. Sub-Menu holiday booking" 
					+ "\n9. Sub-Menu payment"
					+ "\n10. Exit Menu"
					);
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
		deptCtrl.saveData();
	}
	
}
