package ie.eamonnsweeney.app.controllers;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;
import ie.eamonnsweeney.app.models.Name;


/**
 * The Class DataController.
 */
public class DataController {
	
	/** The file IO controller. */
	private FileIOController fileIOController;
	
	/** The employees data file. */
	private File employeesDataFile;
	
	/** The departments data file. */
	private File departmentsDataFile;
	
	/** The help file. */
	private File helpFile;
	
	/** The employees. */
	private ArrayList<Employee> employees;
	
	/** The departments. */
	private ArrayList<Department> departments;
	
	/** The help. */
	private String help;
	
	/**
	 * Instantiates a new data controller.
	 */
	public DataController() {
		this.fileIOController = new FileIOController();
		this.employeesDataFile = new File("src/ie/eamonnsweeney/app/data/employees.dat");
		this.departmentsDataFile = new File("src/ie/eamonnsweeney/app/data/departments.dat");
		this.helpFile = new File("src/ie/eamonnsweeney/app/data/help.txt");
		this.departments = loadDepartments();
		this.employees = loadEmployees();
		this.help = loadHelp();
		addEmployeesToDepartments();
	}
	
	/**
	 * Gets the employees.
	 *
	 * @return the employees
	 */
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	/**
	 * Gets the departments.
	 *
	 * @return the departments
	 */
	public ArrayList<Department> getDepartments() {
		return departments;
	}

	/**
	 * Gets the help.
	 *
	 * @return the help
	 */
	public String getHelp() {
		return help;
	}

	/**
	 * Save data.
	 */
	public void saveData() {
		fileIOController.writeGenericArrayList(departments, departmentsDataFile);
		fileIOController.writeGenericArrayList(employees, employeesDataFile);
	}
	
	/**
	 * Load departments.
	 *
	 * @return the array list
	 */
	private ArrayList<Department> loadDepartments() {
		
		// File.length() returns 0L if a file is empty or does not exist.
		if (departmentsDataFile.length() != 0) {
			return readDepartmentsFromFile();
		} 
		
		return createInitialDepartmentData();
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
	 * Creates the initial department data.
	 *
	 * @return the array list
	 */
	private ArrayList<Department> createInitialDepartmentData() {
		ArrayList<Department> departments = new ArrayList<>();
		
		departments.add(new Department(1, "Development", 0));
		departments.add(new Department(2, "DevOps", 0));
		departments.add(new Department(3, "QA", 0));

		return departments;	
	}
	
	/**
	 * Load employees.
	 *
	 * @return the array list
	 */
	private ArrayList<Employee> loadEmployees() {
		
		// File.length() returns 0L if a file is empty or does not exist.
		if (employeesDataFile.length() != 0) {
			return readEmployeesFromFile();
		}
			
		return createInitialEmployeeData();
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
	 * Creates the initial employee data.
	 *
	 * @return the array list
	 */
	private ArrayList<Employee> createInitialEmployeeData() {
		ArrayList<Employee> employees = new ArrayList<>();
		
		employees.add(new Manager(1, new Name("Mr", "Scrooge", "McDuck"), 
				1, LocalDate.of(2014, 1, 12), "5551234560", 0, 60000, .15));
		employees.add(new Manager(2, new Name("Mr", "Donald", "Duck"), 
				2, LocalDate.of(2014, 1, 12), "5551234561", 0, 55000, .15));
		employees.add(new Developer(3, new Name("Mr", "Huey", "Duck"),
				1, LocalDate.of(2014, 2, 28), "5551234562", Developer.Level.ONE));
		employees.add(new Developer(4, new Name("Mr", "Dewey", "Duck"),
				1, LocalDate.of(2014, 3, 14), "5551234563", Developer.Level.TWO));
		employees.add(new Developer(5, new Name("Mr", "Louie", "Duck"),
				3, LocalDate.of(2014, 4, 1), "5551234564", Developer.Level.THREE));
		
		return employees;
	}
	
	/**
	 * Load help.
	 *
	 * @return the string
	 */
	private String loadHelp() {
		return fileIOController.readTextFile(helpFile);
	}
	
	public void addEmployeesToDepartments() {
		int deptNumEmployees = 0;
		
		for (Department department : departments) {
			deptNumEmployees = 0;
			for (Employee employee : employees) {
				if (employee.getIdNum() == department.getIdNum()) {
					deptNumEmployees++;
				}
			}
			department.setNumEmployees(deptNumEmployees);
		}
		
	}
}
