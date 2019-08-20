package ie.eamonnsweeney.app.controllers;

import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;
import ie.eamonnsweeney.app.models.Menu;


/**
 * The Class EmployeesController.
 */
public class EmployeesController {

	/** The input controller. */
	private InputController inputController;
	
	/** The departments. */
	private ArrayList<Department> departments;
	
	/** The employees. */
	private ArrayList<Employee> employees;
	
	/** The next employee id num. */
	private int nextEmployeeIdNum;
	
	/** The max managers per department. */
	private final int MAX_MANAGERS_PER_DEPARTMENT = 2;
	
	/** The max employees per department. */
	private final int MAX_EMPLOYEES_PER_DEPARTMENT = 14;
	
	/**
	 * Instantiates a new employees controller.
	 *
	 * @param dataController the data controller
	 * @param inputController the input controller
	 */
	public EmployeesController(DataController dataController, InputController inputController) {
		this.employees = dataController.getEmployees();
		this.departments = dataController.getDepartments();
		this.inputController = inputController;
		this.nextEmployeeIdNum = (getHighestEmployeeIdNum() + 1);
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
	
	/**
	 * Adds the employee.
	 */
	public void addEmployee() {
		String menuTitle = "Add Employee";
		String[] menuItems = {
				"Add Manager", 
				"Add Developer", 
				"Return to Main Menu"
				};
		Menu menu = new Menu(inputController, menuTitle, menuItems);
		boolean exitMenu = false;
		
		do {
			menu.display();
			switch (menu.getOption()) {
			case 1:
				addManager();
				break;
			case 2:
				addDeveloper();
				break;
			case 3:
				return;
			}
		} while (!exitMenu);
		
	}
	
	/**
	 * Adds a new manager.
	 */
	public void addManager() {
		if (canAddManager()) {
			ManagerController mc = new ManagerController(departments, employees, inputController);
			employees.add(mc.createNewManager(nextEmployeeIdNum));
			nextEmployeeIdNum++;
			System.out.println("Manager added.");
		} else {
			System.out.println("Cannot add a Manager - there are no managerial vacancies.");
		}
	}
	

	/**
	 * Adds a new developer.
	 */
	public void addDeveloper() {
		if (canAddEmployee()) {
			DeveloperController dc = new DeveloperController(departments, employees, inputController);
			employees.add(dc.createNewDeveloper(nextEmployeeIdNum));
			nextEmployeeIdNum++;
			System.out.println("Manager added.");
		} else {
			System.out.println("Cannot add a developer - there are no vacancies at this time.");
		}
	}
	

	/**
	 * Edits the employee.
	 */
	public void editEmployee() {
		int max = (nextEmployeeIdNum - 1);
		int id = inputController.getInteger("Employee ID to edit (1-" + max + "): ", 1, max);
		boolean idFound = false;
		
		for (Employee e : employees) {
			if (e.getIdNum() == id) {
				if (e instanceof Manager) {
					ManagerController mc = new ManagerController(departments, employees, inputController);
					mc.edit(e);
				} else {
					DeveloperController dc = new DeveloperController(departments, employees, inputController);
					dc.edit(e);
				}
				idFound = true;
				break;
			}
		}
		
		if (!idFound) {
			System.out.println("Employee ID: " + id + " does not exist.");
		}
	}
	
	/**
	 * Delete employee.
	 */
	public void deleteEmployee() {
		int max = (nextEmployeeIdNum - 1);
		int id = inputController.getInteger("Employee ID to delete (1-" + max + "): ", 1, max);
		boolean employeeFound = false;
		
		for (Employee e : employees) {
			if (e.getIdNum() == id) {
				employees.remove(e);
				System.out.println("Employee with ID: " + id + ", deleted successfully.");
				employeeFound = true;
				break;
			}
		}
		
		if (!employeeFound) {
			System.out.println("Employee ID: " + id + " does not exist.");
		}
	}
	
	/**
	 * Gets the highest employee id num.
	 *
	 * @return the highest employee id num
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
	 * Can add a new employee.
	 *
	 * @return true, if successful
	 */
	private boolean canAddEmployee() {
		boolean canAddEmployee = false;
		int departmentIdNum = 0;
		int employeesInDepartment = 0;
		
		for (Department department : departments) {
			departmentIdNum = department.getIdNum();
			employeesInDepartment = 0;
					
			for (Employee employee : employees) {
				if (employee.getDeptIdNum() == departmentIdNum) {
					employeesInDepartment++;
				}
			}
			
			if (employeesInDepartment < MAX_EMPLOYEES_PER_DEPARTMENT) {
				canAddEmployee = true;
				break;
			}
		}
		
		return canAddEmployee;
	}

	/**
	 * Can add a new manager.
	 *
	 * @return true, if successful
	 */
	private boolean canAddManager() {
		boolean canAddManager = false;
		int departmentIdNum = 0;
		int numManagersInDepartment = 0;
		ArrayList<Employee> departmentEmployees;
		
		for (Department department : departments) {
			departmentIdNum = department.getIdNum();
			departmentEmployees = new ArrayList<Employee>();
			numManagersInDepartment = 0;
					
			for (Employee employee : employees) {
				if (employee.getDeptIdNum() == departmentIdNum) {
					departmentEmployees.add(employee);
				}
			}
			
			for (Employee employee : departmentEmployees) {
				if (employee instanceof Manager) {
					numManagersInDepartment++;
				}
			}
			
			if (numManagersInDepartment < MAX_MANAGERS_PER_DEPARTMENT) {
				canAddManager = true;
				break;
			}
		}
		
		return canAddManager;
	}
	
}
