package ie.eamonnsweeney.app.controllers;

import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;


/**
 * The Class EmployeesController.
 */
public class EmployeesController {
	
	/** The employees. */
	private ArrayList<Employee> employees;
	
	/**
	 * Instantiates a new employees controller.
	 *
	 * @param dataController the data controller
	 * @param inputController the input controller
	 */
	public EmployeesController(DataController dataController) {
		this.employees = dataController.getEmployees();
	}
	
	/**
	 * List employees.
	 */
	public void listEmployees() {
		System.out.println("\n*** Employees ***");
		for (Employee e : employees) {
			System.out.print(((e instanceof Manager) ? "Manager" : "Developer") + ": ");
			System.out.println(e);
		}
	}
	
	/**
	 * List managers.
	 */
	public void listManagers() {
		System.out.println("\n*** Managers ***");
		for (Employee e : employees) {
			if (e instanceof Manager) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * List developers.
	 */
	public void listDevelopers() {
		System.out.println("\n*** Developers ***");
		for (Employee e : employees) {
			if (e instanceof Developer) {
				System.out.println(e);
			}
		}
	}
	
}
