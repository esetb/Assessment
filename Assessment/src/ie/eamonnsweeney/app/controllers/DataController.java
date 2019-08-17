package ie.eamonnsweeney.app.controllers;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;
import ie.eamonnsweeney.app.models.Name;

public class DataController {
	private FileIOController fileIOController;
	private File employeesDataFile;
	private File departmentsDataFile;
	private File helpFile;
	private ArrayList<Employee> employees;
	private ArrayList<Department> departments;
	private String help;
	
	public DataController() {
		this.fileIOController = new FileIOController();
		this.employeesDataFile = new File("src/ie/eamonnsweeney/app/data/employees.dat");
		this.departmentsDataFile = new File("src/ie/eamonnsweeney/app/data/departments.dat");
		this.helpFile = new File("src/ie/eamonnsweeney/app/data/help.txt");
		this.departments = loadDepartments();
		this.employees = loadEmployees();
		this.help = loadHelp();
	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}


	public ArrayList<Department> getDepartments() {
		return departments;
	}


	public String getHelp() {
		return help;
	}

	public void saveData() {
		fileIOController.writeGenericArrayList(departments, departmentsDataFile);
		fileIOController.writeGenericArrayList(employees, employeesDataFile);
	}
	
	private ArrayList<Department> loadDepartments() {
		
		// File.length() returns 0L if a file is empty or does not exist.
		if (departmentsDataFile.length() != 0) {
			return readDepartmentsFromFile();
		} else {
			return createInitialDepartmentData();
		}
		
	}
	
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
	
	private ArrayList<Department> createInitialDepartmentData() {
		ArrayList<Department> departments = new ArrayList<>();
		
		departments.add(new Department(1, "Development", 0));
		departments.add(new Department(2, "DevOps", 0));
		departments.add(new Department(3, "QA", 0));

		return departments;	
	}
	
	
	
	private ArrayList<Employee> loadEmployees() {
		
		// File.length() returns 0L if a file is empty or does not exist.
		if (employeesDataFile.length() != 0) {
			return readEmployeesFromFile();
		} else {
			return createInitialEmployeeData();
		}
		
	}
	
	
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
	
	private String loadHelp() {
		return fileIOController.readTextFile(helpFile);
	}
}
