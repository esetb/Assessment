/**
 * AppController - The Application Controller.
 */
package com.eamonn_sweeney.app.controller;

import java.util.ArrayList;
import com.eamonn_sweeney.app.model.Department;
import com.eamonn_sweeney.app.model.Developer;
import com.eamonn_sweeney.app.model.Employee;
import com.eamonn_sweeney.app.model.Manager;
import com.eamonn_sweeney.app.view.Menu;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class Application {
	
	private ArrayList<Employee> employees;
	private ArrayList<Department> departments;
	private String help;
	private int nextEmployeeIdNum;
	private int nextDepartmentIdNum;
	private FileIO files;
	private ConsoleInput input;
	
	/**
	 * 
	 */
	public Application() {
		this.input = new ConsoleInput();
		this.files = new FileIO();
		this.files.doIntegrityCheck();
		this.employees = files.readEmployeesFromFile();
		this.departments = files.readDepartmentsFromFile();
		this.help = files.readHelpFile();
		this.nextEmployeeIdNum = (getHighestEmployeeIdNum() + 1);
		this.nextDepartmentIdNum = (getHighestDepartmentIdNum() + 1);
	}
	
	/**
	 * 
	 */
	public void run() {
		doMainMenu();
		doSaveData();
	}
	
	/**
	 * 
	 */
	private void doMainMenu() {
		int menuChoice = 0;
		int exitChoice = 10;
		
		do {
			Menu.displayMain();
			menuChoice = input.getInteger("Please enter an integer between 1 and 10: ", 1, 10);
			switch (menuChoice) {
			case 1:
				listAllEmployees();
				break;
			case 2:
				addNewEmployee();
				break;
			case 3:
				editEmployeeById();
				break;
			case 4:
				deleteEmployeeById();
				break;
			case 5:
				listAllManagers();
				break;
			case 6:
				listAllDevelopers();
				break;
			case 7:
				viewNumStaffInDepartment();
				break;
			case 8:
				doSubMenuHolidayBooking();
				break;
			case 9:
				doSubMenuPayment();
				break;
			default:
				break;
			}
		} while (menuChoice != exitChoice);
		
		System.out.println("Goodbye!");
	}
	
	/**
	 * 
	 */
	private void listAllEmployees() {
		for (Employee e : employees) {
			System.out.println(e);
		}
	}
	
	/**
	 * 
	 */
	private void addNewEmployee() {
		System.out.println("addNewEmployee() called.");
	}
	
	/**
	 * 
	 */
	private void addNewDeveloper() {
		
	}
	
	/**
	 * 
	 */
	private void addNewManager() {

	}
	
	/**
	 * 
	 */
	private void editEmployeeById() {
		System.out.println("editEmployeeById() called.");
	}
	
	/**
	 * 
	 */
	private void deleteEmployeeById() {
		System.out.println("deleteEmployeeById() called.");
	}
	
	/**
	 * 
	 */
	private void listAllDevelopers() {
		for (Employee e : employees) {
			if (e instanceof Developer) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * 
	 */
	private void listAllManagers() {
		for (Employee e : employees) {
			if (e instanceof Manager) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * 
	 */
	private void viewNumStaffInDepartment() {
		System.out.println("viewNumStaffInDepartment() called.");
	}
	
	/**
	 * 
	 */
	private void doSubMenuHolidayBooking() {
		System.out.println("doSubMenuHolidayBooking() called.");
	}
	
	/**
	 * 
	 */
	private void doSubMenuPayment() {
		System.out.println("doSubMenuPayment() called.");
	}

	/**
	 * 
	 */
	private void doSaveData() {
		files.writeEmployeesToFile(employees);
		files.writeDepartmentsToFile(departments);
	}
	
	/**
	 * 
	 */
	private int getHighestEmployeeIdNum() {
		int highestIdNum = 0;
		int idNum = 0;
		
		for (Employee e : employees) {
			idNum = e.getIdNum();
			if (idNum > highestIdNum) {
				highestIdNum = idNum;
			}
		}
		
		return highestIdNum;
	}
	
	/**
	 * 
	 */
	private int getHighestDepartmentIdNum() {
		int highestIdNum = 0;
		int idNum = 0;
		
		for (Department d : departments) {
			idNum = d.getIdNum();
			if (idNum > highestIdNum) {
				highestIdNum = idNum;
			}
		}
		
		return highestIdNum;
	}
	
}
