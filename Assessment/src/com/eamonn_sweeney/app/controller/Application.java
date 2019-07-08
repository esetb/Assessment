/**
 * AppController - The Application Controller.
 */
package com.eamonn_sweeney.app.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import com.eamonn_sweeney.app.model.Department;
import com.eamonn_sweeney.app.model.Employee;
// temporary imports to populate arrays.
import com.eamonn_sweeney.app.model.Developer;
import com.eamonn_sweeney.app.model.Manager;
import com.eamonn_sweeney.app.model.Name;


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
	
	/**
	 * 
	 */
	public Application() {
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
		doMainLoop();
		doSaveData();
	}
	
	
	/**
	 * 
	 */
	private void doMainLoop() {
		// display menu
		// get user choice
		// switch choice and call methods
		for (Employee emp : employees) {
			System.out.println(emp);
		}
		System.out.println();
		
		for (Department dept : departments) {
			System.out.println(dept);
		}
		System.out.println("\n" + help);
	
		System.out.println("Next Employee ID = " + nextEmployeeIdNum);
		System.out.println("Next Department ID = " + nextDepartmentIdNum);
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
