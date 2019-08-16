package ie.eamonnsweeney.app.controllers;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;
import ie.eamonnsweeney.app.models.Menu;
import ie.eamonnsweeney.app.models.Name;

public class EmployeesController {

	
	/** The employees data file. */
	private File employeesDataFile;
	
	/** The employees. */
	private ArrayList<Employee> employees;
	
	/** The next employee id num. */
	private int nextEmployeeIdNum;
	
	
	
	public EmployeesController() {
		this.employees = loadEmployees();
		this.nextEmployeeIdNum = (getHighestEmployeeIdNum() + 1);
	}
	
	/**
	 * List employees.
	 */
	public void listEmployees() {
		System.out.println("\n*** Employees ***");
		for (Employee e : employees) {
			System.out.print(
					((e instanceof Manager) ? "Manager" : "Developer") + ": ");
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
		boolean deletionOcurred = false;
		
		for (Employee e : employees) {
			if (e.getIdNum() == id) {
				employees.remove(e);
				System.out.println("Employee with ID: " + id + ", deleted successfully.");
				deletionOcurred = true;
				break;
			}
		}
		
		if (!deletionOcurred) {
			System.out.println("Employee ID: " + id + " does not exist.");
		}
	}
	
	/**
	 * Load employees.
	 *
	 * @return the array list
	 */
	private ArrayList<Employee> loadEmployees() {
		ArrayList<Employee> employees = new ArrayList<>();
		
		// File.length() returns 0L if a file is empty or does not exist.
		if (employeesDataFile.length() == 0) {
			employees.add(new Manager(1, new Name("Mr", "Scrooge", "McDuck"), 
					1, LocalDate.of(2014, 1, 12), "5551234560", 0, 60000, .155));
			employees.add(new Manager(2, new Name("Mr", "Donald", "Duck"), 
					2, LocalDate.of(2014, 1, 12), "5551234561", 0, 60000, .155));
			employees.add(new Developer(3, new Name("Mr", "Huey", "Duck"),
					1, LocalDate.of(2014, 2, 28), "5551234562", Developer.Level.ONE));
			employees.add(new Developer(4, new Name("Mr", "Dewey", "Duck"),
					1, LocalDate.of(2014, 3, 14), "5551234563", Developer.Level.TWO));
			employees.add(new Developer(5, new Name("Mr", "Louie", "Duck"),
					3, LocalDate.of(2014, 4, 1), "5551234564", Developer.Level.THREE));
		} else {
			employees = readEmployeesFromFile();
		}
		
		return employees;	
	}
	
	/**
	 * Read employees from file.
	 *
	 * @return the array list
	 */
	private ArrayList<Employee> readEmployeesFromFile() {
		ArrayList<?> genericArrayListObject = files.readGenericArrayList(employeesDataFile);
		ArrayList<Employee> employees = new ArrayList<>();
	
		for (Object obj : genericArrayListObject) {
			if (obj instanceof Employee) {
				employees.add((Employee) obj);
			}
		}
		
		return employees;
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
		ArrayList<Employee> departmentEmployees;
		
		for (Department department : departments) {
			departmentIdNum = department.getIdNum();
			departmentEmployees = new ArrayList<Employee>();
					
			for (Employee employee : employees) {
				if (employee.getDeptIdNum() == departmentIdNum) {
					departmentEmployees.add(employee);
				}
			}
			
			if (departmentEmployees.size() < MAX_EMPLOYEES_PER_DEPARTMENT) {
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
