package ie.eamonnsweeney.app.controllers;

import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;


/**
 * The Class DepartmentsController.
 */
public class DepartmentsController {
	
	/** The departments. */
	private ArrayList<Department> departments;
	
	/** The employees. */
	private ArrayList<Employee> employees;
	
	/** The input controller. */
	private InputController inputController;
	
	/**
	 * Instantiates a new departments controller.
	 *
	 * @param dataController the data controller
	 * @param inputController the input controller
	 */
	public DepartmentsController(DataController dataController, InputController inputController) {
		this.employees = dataController.getEmployees();
		this.departments = dataController.getDepartments();
		this.inputController = inputController;
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
	
	/**
	 * View department.
	 */
	public void viewDepartmentbyId() {
		int deptIdNum = inputController.getInteger("Department ID (1-3):");
		boolean departmentFound = false;
		
		for (Department department : departments) {
			if (department.getIdNum() == deptIdNum) {
				departmentFound = true;
				ArrayList<Manager> managers = new ArrayList<>();
				ArrayList<Developer> developers = new ArrayList<>();
				
				for (Employee employee : employees) {
					if (employee.getDeptIdNum() == deptIdNum) {
						if (employee instanceof Manager) {
							managers.add((Manager) employee);
						} else {
							developers.add((Developer) employee);
						}
					}
				}
				System.out.println("\n*** View Department ***");
				System.out.println("ID: " + department.getIdNum());
				System.out.println("Name: " + department.getName());
				System.out.println("Employees: " + department.getNumEmployees());
				if (managers.size() > 0) {
					System.out.println("Managers:");
					for (Manager manager : managers) {
						System.out.println("\t" 
								+ manager.getName().getTitle() + " " 
								+ manager.getName().getFirstName() + " "
								+ manager.getName().getLastName());
					}
				}
				if (developers.size() > 0) {
					System.out.println("Developers:");
					for (Developer developer : developers) {
						System.out.println("\t" 
								+ developer.getName().getTitle() + " " 
								+ developer.getName().getFirstName() + " "
								+ developer.getName().getLastName());
					}
				}
			}
		}
		
		if (!departmentFound) {
			System.out.println("Error: No department exists with that id number.");
		}
	}
	
}
