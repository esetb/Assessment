/**
 * ApplicationController
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
public class ApplicationController {
	
	private ArrayList<Employee> employees;
	private ArrayList<Department> departments;
	private String help;
	private int nextEmployeeIdNum;
	private int nextDepartmentIdNum;
	private FileIOController files;
	private InputController input;
	int menuOption = 0;
	
	/**
	 * 
	 */
	public ApplicationController() {
		this.input = new InputController();
		this.files = new FileIOController();
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
		boolean exitMenu = false;
		
		do {
			Menu.displayMainMenu();
			menuOption = input.getInteger("Please enter a menu option #: ", 1, 10);
			switch (menuOption) {
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
			case 10:
				exitMenu = true;
			default:
				break;
			}
		} while (!exitMenu);
		
		input.close();
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
		Employee emp = null;
		
		Menu.displayNewEmployeeMenu();
		menuOption = input.getInteger("Please enter a menu option #: ", 1, 3);
		switch (menuOption) {
		case 1:
			emp = createNewManager();
			break;
		case 2:
			emp = createNewDeveloper();
			break;
		case 3:
			return;
		}
		
		employees.add(emp);
		nextEmployeeIdNum++;
	}
	
	/**
	 * 
	 */
	private void inputEmployeeData(Employee e) {
		
		
	}
	
	/**
	 * 
	 */
	private Manager createNewManager() {
		
		return null;
	}
	
	/**
	 * 
	 */
	private Developer createNewDeveloper() {
		
		return null;
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
