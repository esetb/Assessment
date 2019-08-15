/**
 * ApplicationController
 */
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


// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationController.
 *
 * @author Eamonn A. Sweeney
 */
public class ApplicationController {
	
	/** The file IO controller. */
	private FileIOController fileIOController;
	
	/** The departments data file. */
	private File departmentsDataFile;
	
	/** The employees data file. */
	private File employeesDataFile;
	
	/** The input controller. */
	private InputController inputController;
	
	/** The departments. */
	private ArrayList<Department> departments;
	
	/** The employees. */
	private ArrayList<Employee> employees;
	
	/** The next department id num. */
	private int nextDepartmentIdNum;
	
	/** The next employee id num. */
	private int nextEmployeeIdNum;
	
	/** The max managers per department. */
	private final int MAX_MANAGERS_PER_DEPARTMENT = 2;
	
	/** The max employees per department. */
	private final int MAX_EMPLOYEES_PER_DEPARTMENT = 2;
	
	/**
	 * Instantiates a new application controller.
	 */
	public ApplicationController() {
		this.fileIOController = new FileIOController();
		this.employeesDataFile = new File("src/ie/eamonnsweeney/app/data/employees.dat");
		this.departmentsDataFile = new File("src/ie/eamonnsweeney/app/data/departments.dat");
		this.inputController = new InputController();
		this.employees = loadEmployees();
		this.departments = loadDepartments(); // loadDepartments uses employees
		this.nextDepartmentIdNum = (getHighestDepartmentIdNum() + 1);
		this.nextEmployeeIdNum = (getHighestEmployeeIdNum() + 1);
	}
	
	/**
	 * Run the Application.
	 */
	public void run() {
		displayMainMenu();
		storeData();
		inputController.close();
	}	

	/**
	 * Display the main menu.
	 */
	private void displayMainMenu() {
		String menuTitle = "Main Menu";
		String[] menuItems = {
				"List Departments",
				"View Department",
				"List Employees", 
				"List Managers",
				"List Developers",
				"Add Employee",
				"Edit Employee",
				"Delete Employee",
				"Payment",
				"Show Help", 
				"Exit Program"
				};
		Menu menu = new Menu(inputController, menuTitle, menuItems);
		boolean exitMenu = false;
		
		do {
			menu.display();
			switch (menu.getOption()) {
			case 1:
				listDepartments();
				break;
			case 2:
				viewDepartment();
				break;
			case 3:
				listEmployees();
				break;
			case 4:
				listManagers();
				break;
			case 5:
				listDevelopers();
				break;
			case 6:
				addEmployee();
				break;
			case 7:
				editEmployee();
				break;
			case 8:
				deleteEmployee();
				break;
			case 9:
				// payment();
				break;
			case 10:
				// show help
				break;
			case 11:
				exitMenu = true;
			}
		} while (!exitMenu);
		
		System.out.println("Goodbye!");
	}
	
	/**
	 * List departments.
	 */
	private void listDepartments() {
		System.out.println("\n*** Departments ***");
		for (Department e : departments) {
			System.out.println(e);
		}
	}
	
	/**
	 * View department.
	 */
	private void viewDepartment() {
		int deptIdNum = inputController.getInteger("Department ID (1-" 
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
	 * Load departments.
	 *
	 * @return the array list
	 */
	private ArrayList<Department> loadDepartments() {
		ArrayList<Department> departments = new ArrayList<>();
		
		// File.length() returns 0L if a file is empty or does not exist.
		if (departmentsDataFile.length() == 0) {
			departments.add(new Department(1, "Development", 0));
			departments.add(new Department(2, "DevOps", 0));
			departments.add(new Department(3, "QA", 0));
			for (Department department : departments) {
				for(Employee employee : employees) {
					if (employee.getDeptIdNum() == department.getIdNum()) {
						department.setNumEmployees(department.getNumEmployees() + 1);
					}
				}
			}
		} else {
			departments = readDepartmentsFromFile();
		}
		
		return departments;	
	}
	
	/**
	 * Read departments from file.
	 *
	 * @return the array list
	 */
	private ArrayList<Department> readDepartmentsFromFile() {
		ArrayList<?> genericArrayListObject = fileIOController.readGenericArrayList(departmentsDataFile);
		ArrayList<Department> departments = new ArrayList<>();
	
		for (Object obj : genericArrayListObject) {
			if (obj instanceof Department) {
				departments.add((Department) obj);
			}
		}
		
		return departments;
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


	/**
	 * List employees.
	 */
	private void listEmployees() {
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
	private void listManagers() {
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
	private void listDevelopers() {
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
	private void addEmployee() {
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
	private void addManager() {
		if (canAddManager()) {
			ManagerController mc = new ManagerController(departments, 
					 (nextDepartmentIdNum -1), inputController);
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
	private void addDeveloper() {
		if (canAddEmployee()) {
			DeveloperController dc = new DeveloperController(departments, 
					(nextDepartmentIdNum -1), inputController);
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
	private void editEmployee() {
		int max = (nextEmployeeIdNum - 1);
		int id = inputController.getInteger("Employee ID to edit (1-" + max + "): ", 1, max);
		boolean idFound = false;
		
		for (Employee e : employees) {
			if (e.getIdNum() == id) {
				if (e instanceof Manager) {
					ManagerController mc = new ManagerController(departments, 
							(nextDepartmentIdNum -1), inputController);
					mc.edit(e);
				} else {
					DeveloperController dc = new DeveloperController(departments, 
							(nextDepartmentIdNum -1), inputController);
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
	private void deleteEmployee() {
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
		ArrayList<?> genericArrayListObject = fileIOController.readGenericArrayList(employeesDataFile);
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
	
	/**
	 * Store data.
	 */
	private void storeData() {
		fileIOController.writeGenericArrayList(departments, departmentsDataFile);
		fileIOController.writeGenericArrayList(employees, employeesDataFile);
	}
	
}
