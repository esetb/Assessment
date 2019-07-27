/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import java.io.File;
import java.util.ArrayList;

import ie.eamonnsweeney.app.helpers.FileIO;
import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Menu;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class DepartmentsController {

	private File dataFile;
	private ArrayList<Department> departments;
	private int nextIdNum;
	
	/**
	 * 
	 */
	public DepartmentsController() {
		this.dataFile = new File("src/ie/eamonnsweeney/app/data/departments.dat");
		this.departments = loadData();
		this.nextIdNum = (getHighestIdNum() + 1);
	}

	/**
	 * 
	 */
	public void displayMenu() {
		String menuTitle = "Departments Menu";
		String[] menuItems = {
				"List All", 
				"View Department", 
				"Show Help", 
				"Return to Main Menu"
				};
		Menu menu = new Menu(menuTitle, menuItems);
		boolean exitMenu = false;
		
		do {
			menu.display();
			switch (menu.getOption()) {
			case 1:
				listAll();
				break;
			case 2:
				// list dept details (id name # employees/managers/developers).
			case 3:
				// show help
				break;
			case 4:
				exitMenu = true;
			}
		} while (!exitMenu);
		
	}
	
	/**
	 * 
	 */
	public void listAll() {
		for (Department e : departments) {
			System.out.println(e);
		}
	}
	
	/**
	 * 
	 */
	public void saveData() {
		FileIO.writeGenericArrayList(departments, dataFile);
	}
	
	/**
	 * 
	 * 
	 */
	private ArrayList<Department> loadData() {
		ArrayList<Department> departments = new ArrayList<>();
		
		// File.length() returns 0L if a file is empty or does not exist.
		if (dataFile.length() == 0) {
			departments.add(new Department(1, "Development", 0));
			departments.add(new Department(2, "DevOps", 0));
			departments.add(new Department(3, "QA", 0));
		} else {
			departments = readDataFromFile();
		}
		
		return departments;	
	}
	
	/**
	 * 
	 */
	private ArrayList<Department> readDataFromFile() {
		ArrayList<?> genericArrayListObject = FileIO.readGenericArrayList(dataFile);
		ArrayList<Department> departments = new ArrayList<>();
	
		for (Object obj : genericArrayListObject) {
			if (obj instanceof Department) {
				departments.add((Department) obj);
			}
		}
		
		return departments;
	}
	
	/**
	 * 
	 */
	private int getHighestIdNum() {
		int highestIdNum = 0;
		int idNum = 0;
		
		for (Department e : departments) {
			idNum = e.getIdNum();
			if (idNum > highestIdNum) {
				highestIdNum = idNum;
			}
		}
		
		return highestIdNum;
	}
	
}
