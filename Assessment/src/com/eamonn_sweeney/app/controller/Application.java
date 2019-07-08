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
		files.writeEmployeesToFile(employees);
		files.writeDepartmentsToFile(departments);
	}
	
	
	/**
	 * 
	 */
	private void doMainLoop() {
		// display menu
		// get user choice
		// switch choice and call methods
		
		ArrayList<Employee> employees = new ArrayList<>();
		Developer dev1 = new Developer(1, new Name("Mr", "Donald", "Duck"), 0, 
				LocalDate.now(), "---");
		Developer dev2 = new Developer(2, new Name("Mr", "Michael", "Mouse"), 0, 
				LocalDate.now(), "---");
		Manager man1 = new Manager(3, new Name("Ms", "Minnie", "Mouse"), 0, 
				LocalDate.now(), "---", 4, 60000, .1);
		employees.add(dev1);
		employees.add(dev2);
		employees.add(man1);
		
		ArrayList<Department> departments = new ArrayList<>();
		departments.add(new Department(1, "DevOps", 2));
		departments.add(new Department(2, "Development", 4));
		departments.add(new Department(312, "HR", 8));
		
		
		files.writeEmployeesToFile(employees);
		files.writeDepartmentsToFile(departments);
		
		System.out.println();
		for (Employee emp : employees) {
			System.out.println(emp);
		}
		
		System.out.println();
		for (Department dept : departments) {
			System.out.println(dept);
		}
		
		System.out.println();
		System.out.println(help);
		
		System.out.println("Next Employee ID = " + nextEmployeeIdNum);
		System.out.println("Next Department ID = " + nextDepartmentIdNum);
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
