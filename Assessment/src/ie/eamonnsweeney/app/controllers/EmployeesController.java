/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import ie.eamonnsweeney.app.models.DataStorable;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;
import ie.eamonnsweeney.app.models.Menu;
import ie.eamonnsweeney.app.models.Name;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class EmployeesController implements DataStorable {

	private FileIOController fileIOController;
	private InputController inputController;
	private File dataFile;
	private ArrayList<Employee> employees;
	private int nextIdNum;
	
	/**
	 * 
	 */
	public EmployeesController(FileIOController fileIOController, InputController inputController) {
		this.fileIOController = fileIOController;
		this.inputController = inputController;
		this.dataFile = new File("src/ie/eamonnsweeney/app/data/employees.dat");
		this.employees = loadData();
		this.nextIdNum = (getHighestIdNum() + 1);
	}
	
	
	/**
	 * 
	 */
	public void displayMenu() {
		String menuTitle = "Employees Menu";
		String[] menuItems = {
				"List All", 
				"List Managers", 
				"List Developers",
				"Add Employee",
				"Edit Employee",
				"Delete Employee",
				"Payment",
				"Show Help", 
				"Return to Main Menu"
				};
		Menu menu = new Menu(inputController, menuTitle, menuItems);
		boolean exitMenu = false;

		do {
			menu.display();
			switch (menu.getOption()) {
			case 1:
				listAll();
				break;
			case 2:
				listManagers();
				break;
			case 3:
				listDevelopers();
				break;
			case 4:
				addNew();
				break;
			case 5:
				editById();
				break;
			case 6:
				deleteById();
				break;
			case 7:
				// payment
				break;
			case 8:
				// show help - employees
				break;
			case 9:
				exitMenu = true;
				break;
			}
		} while (!exitMenu);
		
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
	public void listManagers() {
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
	public void listDevelopers() {
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
	public void addNew() {
		String menuTitle = "Add Employee";
		String[] menuItems = {
				"Add Manager", 
				"Add Developer", 
				"Return to Main Menu"
				};
		Menu menu = new Menu(inputController, menuTitle, menuItems);
		boolean exitMenu = false;
		Employee emp = null;
		
		do {
			menu.display();
			switch (menu.getOption()) {
			case 1:
				emp = addNewManager();
				break;
			case 2:
				emp = addNewDeveloper();
				break;
			case 3:
				return;
			}
		} while (!exitMenu);
		
		employees.add(emp);
		nextIdNum++;
		System.out.println("Employee added.");
	}
	
	/**
	 * 
	 */
	public void editById() {
		int max = (nextIdNum - 1);
		int id = inputController.getInteger("Employee ID to edit (1-" + max + "): ", 1, max);
		boolean idFound = false;
		
		for (Employee e : employees) {
			if (e.getIdNum() == id) {
				if (e instanceof Manager) {
					ManagerController mc = new ManagerController(inputController);
					mc.edit(e);
				} else {
					DeveloperController dc = new DeveloperController(inputController);
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
	 * 
	 */
	public void deleteById() {
		int max = (nextIdNum - 1);
		int id = inputController.getInteger("Employee ID to delete (1-" + max + "): ", 1, max);
		boolean idFound = false;
		
		for (Employee e : employees) {
			if (e.getIdNum() == id) {
				employees.remove(e);
				System.out.println("Employee with ID: " + id + ", deleted successfully.");
				idFound = true;
				break;
			}
		}
		
		if (!idFound) {
			System.out.println("Employee ID: " + id + " does not exist.");
		}
	}
	
	/**
	 * 
	 */
	public void storeData() {
		fileIOController.writeGenericArrayList(employees, dataFile);
	}
	
	/**
	 * 
	 */
	private Manager addNewManager() {
		ManagerController mc = new ManagerController(inputController);
		return mc.createNewManager(nextIdNum);
	}
	
	/**
	 * 
	 */
	private Developer addNewDeveloper() {
		DeveloperController dc = new DeveloperController(inputController);
		return dc.createNewDeveloper(nextIdNum);
	}
	
	/**
	 *  
	 */
	private ArrayList<Employee> loadData() {
		ArrayList<Employee> employees = new ArrayList<>();
		
		// File.length() returns 0L if a file is empty or does not exist.
		if (dataFile.length() == 0) {
			employees.add(new Manager(1, new Name("Mr", "Scrooge", "McDuck"), 
					1, LocalDate.of(2014, 1, 12), "5551234560", 10, 60000, .155));
			employees.add(new Manager(1, new Name("Mr", "Donald", "Duck"), 
					1, LocalDate.of(2014, 1, 12), "5551234560", 10, 60000, .155));
			employees.add(new Developer(3, new Name("Mr", "Huey", "Duck"),
					1, LocalDate.of(2014, 2, 28), "5551234561", Developer.Level.ONE));
			employees.add(new Developer(4, new Name("Mr", "Dewey", "Duck"),
					1, LocalDate.of(2014, 3, 14), "5551234562", Developer.Level.TWO));
			employees.add(new Developer(5, new Name("Mr", "Louie", "Duck"),
					1, LocalDate.of(2014, 4, 1), "5551234563", Developer.Level.THREE));
		} else {
			employees = readDataFromFile();
		}
		
		return employees;	
	}
	
	/**
	 * 
	 */
	private ArrayList<Employee> readDataFromFile() {
		ArrayList<?> genericArrayListObject = fileIOController.readGenericArrayList(dataFile);
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
