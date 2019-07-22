/**
 * File Input/Output
 */
package com.eamonn_sweeney.app.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import com.eamonn_sweeney.app.model.Department;
import com.eamonn_sweeney.app.model.Developer;
import com.eamonn_sweeney.app.model.Developer.Level;
import com.eamonn_sweeney.app.model.Employee;
import com.eamonn_sweeney.app.model.Manager;
import com.eamonn_sweeney.app.model.Name;


/**
 * @author Eamonn A. Sweeney
 * 
 */
public class FileIOController {

	private File dataDir;
	private File employeesFile;
	private File departmentsFile;
	private File helpFile;

	/**
	 * 
	 */
	public FileIOController() {
		setFilePaths(new File("src/com/eamonn_sweeney/app/data"));
	}

	/**
	 * @param dataDir
	 */
	public FileIOController(File dataDir) {
		setFilePaths(dataDir);
	}

	/**
	 * 
	 */
	private void setFilePaths(File dataDir) {
		this.dataDir = dataDir;
		this.employeesFile = new File(this.dataDir + "/employees.dat");
		this.departmentsFile = new File(this.dataDir + "/departments.dat");
		this.helpFile = new File(this.dataDir + "/help.txt");
	}

	/**
	 * Check if data files exist or if they are empty and if so generate some data.
	 */
	public void checkDataExists() {
		// File.length() returns 0L if a file is empty or does not exist.
		if (employeesFile.length() == 0) {
			generateInitialEmployeeData();
		}	
		if (departmentsFile.length() == 0) {
			generateInitialDepartmentData();
		}	
	}
	
	/**
	 * 
	 */
	private void generateInitialEmployeeData() {
		ArrayList<Employee> employees = new ArrayList<>();
			
		employees.add(new Developer(1, new Name("Mr", "Donald", "Duck"), 0, 
					LocalDate.now(), "---", Level.ONE));
		employees.add(new Developer(2, new Name("Mr", "Michael", "Mouse"), 0, 
					LocalDate.now(), "---", Level.TWO));
		employees.add(new Manager(3, new Name("Ms", "Minnie", "Mouse"), 0, 
					LocalDate.now(), "---", 4, 60000, .1));
		employees.add(new Manager(4, new Name("Mr", "Daffy", "Duck"), 0, 
					LocalDate.now(), "---", 4, 60000, .1));
			
		writeEmployeesToFile(employees);
	}
	
	/**
	 * 
	 */
	private void generateInitialDepartmentData() {
		ArrayList<Department> departments = new ArrayList<>();
			
		departments.add(new Department(1, "Legal", 11));
		departments.add(new Department(2, "HR", 12));
		departments.add(new Department(3, "DevOps", 10));
		departments.add(new Department(4, "Development", 8));
		
		writeDepartmentsToFile(departments);
	}
	
	/**
	 * 
	 */
	public ArrayList<Employee> readEmployeesFromFile() {
		ArrayList<?> genericArrayListObject = readArrayListFromFile(employeesFile);
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
	public void writeEmployeesToFile(ArrayList<Employee> employees) {
		writeArrayListToFile(employees, employeesFile);
	}

	/**
	 * 
	 */
	public ArrayList<Department> readDepartmentsFromFile() {
		ArrayList<?> genericArrayListObject = readArrayListFromFile(departmentsFile);
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
	public void writeDepartmentsToFile(ArrayList<Department> departments) {
		writeArrayListToFile(departments, departmentsFile);
	}

	/**
	 * 
	 */
	public String readHelpFile() {
		String help = "";
		String line = null;
		
		if (helpFile.length() == 0) {
			return help;
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(helpFile));) {
			line = null;
		    while ((line = reader.readLine()) != null) {
		    	help += (line + "\n");
		    }
		} catch (IOException e) {
        	e.printStackTrace();
			System.exit(0);
		}
		
		return help;
	}
	
	/**
	 * 
	 */
	private ArrayList<?> readArrayListFromFile(File filePath) {
		ArrayList<?> array = new ArrayList<>();
		
		try (FileInputStream fis = new FileInputStream(filePath); 
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			array = (ArrayList<?>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		return array;
	}

	/**
	 * 
	 */
	private void writeArrayListToFile(ArrayList<?> array, File filePath) {
		try (FileOutputStream fos = new FileOutputStream(filePath);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(array);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
