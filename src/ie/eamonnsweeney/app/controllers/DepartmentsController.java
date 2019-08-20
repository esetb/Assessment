package ie.eamonnsweeney.app.controllers;

import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;


/**
 * The Class DepartmentsController.
 */
public class DepartmentsController {
	
	/** The departments. */
	private ArrayList<Department> departments;
	


	public DepartmentsController(ArrayList<Department> departments) {
		this.departments = departments;
	}
	
	/**
	 * List departments.
	 */
	public void listDepartments() {
		System.out.println("\n*** Departments ***");
		for (Department e : departments) {
			System.out.println(e);
		}
	}
	
}
