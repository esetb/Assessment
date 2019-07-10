/**
 * Menu Class - various static methods to display the applications menu's.
 */
package com.eamonn_sweeney.app.view;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class Menu {

	/**
	 * 
	 */
	public static void displayMainMenu() {
		System.out.println("*** Main Menu ***"
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
	}
	
	/**
	 * 
	 */
	public static void displayAddNewEmployeeMenu() {
		System.out.println();
	}
	
	/**
	 * 
	 */
	public static void displayHolidayBookingMenu() {
		System.out.println();
	}

	/**
	 * 
	 */
	public static void displayPaymentMenu() {
		System.out.println();
	}
	
}
