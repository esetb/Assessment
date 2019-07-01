/**
 * Menu - contains static methods to display the applications various menus.
 */
package com.eamonn_sweeney;

public class Menu {

	public static void displayMain() {
		System.out.println("*** Main Menu ***"
				+ "1. List all Employees" 
				+ "2. Add a new Employee" 
				+ "3. Edit an Employee by id"
				+ "4. Delete an Employee by id" 
				+ "5. View all Mangers" 
				+ "6. View all Developers"
				+ "7. View number of staff within a department" 
				+ "8. Sub-Menu holiday booking" 
				+ "9. Sub-Menu payment"
				+ "10. Exit Menu"
				);
	}
	
	public static void displayHolidayBooking() {
		System.out.println();
	}

	public static void displayPayment() {
		System.out.println();
	}
	
}
