/**
 * Menu - .
 */
package com.eamonn_sweeney;

import java.util.ArrayList;

public class Menu {
	private ArrayList<Employee> employees;
	private ArrayList<Department> departments;
	
	public Menu() {
		/* load data
		 * main loop - run()
		 * write data
		 */
	}
	
	public void run() {
		/* display menu
		 * get user choice
		 * call methods
		 */
	}
	
	public void displayMain() {
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
	
	public void displayHolidayBooking() {
		System.out.println();
	}

	public void displayPayment() {
		System.out.println();
	}
	
}
