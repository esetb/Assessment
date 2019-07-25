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


/**
 * @author Eamonn A. Sweeney
 *
 */
public class EmployeesController {

	private File dataFile;
	private ArrayList<Employee> employees;
	private int nextIdNum;
	
	/**
	 * 
	 */
	public EmployeesController() {
		this.dataFile = new File("src/ie/eamonnsweeney/app/data/employees.dat");
		this.employees = loadData();
		this.nextIdNum = (getHighestIdNum() + 1);
	}
	
	/**
	 * 
	 */
	public void addNew() {
		Employee emp = null;
		int menuOption = 0;
		
		System.out.println("\n" 
				+ "*** Add Employee ***" 
				+ "\n1. Add a Manager" 
				+ "\n2. Add a Developer."
				+ "\n3. Return to Main Menu."
				);
		menuOption = Input.getInteger("Please enter a menu option (1-3): ", 1, 3);
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
		System.out.println("Employee added.\n");
	}
	
	/**
	 * 
	 */
	public void listAll() {
		System.out.println("\n*** Employees ***");
		for (Employee e : employees) {
			System.out.print(
					((e instanceof Manager) ? "Manager" : "Developer") + ": ");
			System.out.println(e);
		}
	}
	
	/**
	 * 
	 */
	public void listAllManagers() {
		System.out.println("\n*** Managers ***");
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
		System.out.println("\n*** Developers ***");
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
		int max = (nextIdNum - 1);
		int id = Input.getInteger("Employee ID to delete (1-" + max + "): ", 1, max);
		boolean deletionOccurred = false;
		
		for (Employee e : employees) {
			if (e.getIdNum() == id) {
				employees.remove(e);
				System.out.println("Employee with ID: " + id + ", deleted successfully.");
				deletionOccurred = true;
				break;
			}
		}
		
		if (!deletionOccurred) {
			System.out.println("Employee ID: " + id + " does not exist.");
		}
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
		Developer developer = dc.createNewDeveloper(nextIdNum);
		
		return developer;
	}
	
	/**
	 *  
	 */
	private ArrayList<Employee> loadData() {
		ArrayList<Employee> employees = new ArrayList<>();
		
		// File.length() returns 0L if a file is empty or does not exist.
		if (dataFile.length() == 0) {
			employees.add(new Developer(1, new Name("Mr", "Donald", "Duck"), 
					1, LocalDate.of(2012, 4, 1), "5551234567", Developer.Level.ONE));
			employees.add(new Developer(2, new Name("Mr", "Michael", "Mouse"),
					3, LocalDate.of(2014, 2, 28), "5551234568", Developer.Level.TWO));
			employees.add(new Manager(3, new Name("Ms", "Minnie", "Mouse"), 
					2, LocalDate.of(2013, 7, 25), "5551234569", 6, 50000, .1));
			employees.add(new Manager(4, new Name("Mr", "Daffy", "Duck"), 
					1, LocalDate.of(2017, 1, 12), "5551234560", 10, 60000, .155));
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
