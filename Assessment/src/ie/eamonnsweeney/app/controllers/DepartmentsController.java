package ie.eamonnsweeney.app.controllers;

import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;

public class DepartmentsController {
	
	private ArrayList<Department> departments;
	private ArrayList<Employee> employees;
	private InputController input;
	private int nextDepartmentIdNum;
	private int[][] departmentVacancies;
	
	public DepartmentsController(ArrayList<Department> departments, 
			ArrayList<Employee> employees,
			InputController input) {
		this.departments = departments;
		this.employees = employees;
		this.input = input;
		this.nextDepartmentIdNum = (getHighestDepartmentIdNum() + 1);
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
	public void viewDepartment() {
		int deptIdNum = input.getInteger("Department ID (1-" 
				+ (nextDepartmentIdNum - 1) + "):");
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
	
	/**
	 * Gets the highest department id num in use.
	 *
	 * @return the highest department id num
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
