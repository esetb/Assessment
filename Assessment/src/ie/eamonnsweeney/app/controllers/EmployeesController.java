/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import ie.eamonnsweeney.app.helpers.FileIO;
import ie.eamonnsweeney.app.helpers.Input;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;
import ie.eamonnsweeney.app.models.Name;
import ie.eamonnsweeney.app.views.Menu;

/**
 * @author Eamonn A. Sweeney
 *
 */
public class EmployeesController {

	private File dataFile;
	private ArrayList<Employee> employees;
	private int nextIdNum;
	private int menuOption;
	
	/**
	 * 
	 */
	public EmployeesController() {
		this.dataFile = new File("src/com/eamonn_sweeney/app/data/employees.dat");
		this.employees = loadData();
		this.nextIdNum = getHighestIdNum();
	}
	
	/**
	 * 
	 */
	public void addNew() {
		Employee emp = null;
		
		Menu.displayAddNewEmployee();
		menuOption = Input.getInteger("Please enter a menu option #: ", 1, 3);
		switch (menuOption) {
		case 1:
			emp = addNewManager();
			break;
		case 2:
			emp = addNewDeveloper();
			break;
		case 3:
			return;
		}
		
		employees.add(emp);
		nextIdNum++;
		System.out.println("Employee added.");
	}
	
	/**
	 * 
	 */
	public void listAll() {
		for (Employee e : employees) {
			System.out.println(e);
		}
	}
	
	/**
	 * 
	 */
	public void listAllManagers() {
		for (Employee e : employees) {
			if (e instanceof Manager) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * 
	 */
	public void listAllDevelopers() {
		for (Employee e : employees) {
			if (e instanceof Developer) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * 
	 */
	public void editById() {
		
	}
	
	/**
	 * 
	 */
	public void deleteById() {
		
	}
	
	/**
	 * 
	 */
	public void saveData() {
		FileIO.writeGenericArrayList(employees, dataFile);
	}
	
	/**
	 * 
	 */
	private Manager addNewManager() {
		ManagerController mc = new ManagerController();
		Manager manager = mc.createNewManager(nextIdNum);
		
		return manager;
	}
	
	/**
	 * 
	 */
	private Developer addNewDeveloper() {
		DeveloperController dc = new DeveloperController();
		dc.inputData();
		
		return dc.createNewDeveloper(nextIdNum);
	}
	
	/**
	 *  
	 */
	private ArrayList<Employee> loadData() {
		ArrayList<Employee> employees = new ArrayList<>();
		
		// File.length() returns 0L if a file is empty or does not exist.
		if (dataFile.length() == 0) {
			employees.add(new Developer(1, new Name("Mr", "Donald", "Duck"), 
					0, LocalDate.of(2010, 1, 25), "---", Developer.Level.ONE));
			employees.add(new Developer(2, new Name("Mr", "Michael", "Mouse"),
					0, LocalDate.of(2010, 1, 25), "---", Developer.Level.TWO));
			employees.add(new Manager(3, new Name("Ms", "Minnie", "Mouse"), 
					0, LocalDate.of(2010, 1, 25), "---", 4, 60000, .1));
			employees.add(new Manager(4, new Name("Mr", "Daffy", "Duck"), 
					0, LocalDate.of(2010, 1, 25), "---", 4, 60000, .1));
		} else {
			employees = readDataFromFile();
		}
		
		return employees;	
	}
	
	/**
	 * 
	 */
	private ArrayList<Employee> readDataFromFile() {
		ArrayList<?> genericArrayListObject = FileIO.readGenericArrayList(dataFile);
		ArrayList<Employee> employees = new ArrayList<>();
	
		for (Object obj : genericArrayListObject) {
			if (obj instanceof Employee) {
				employees.add((Employee) obj);
			}
		}
		
		return employees;
	}
	
	/**
	 * 
	 */
	private int getHighestIdNum() {
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
	
}
