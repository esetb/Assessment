/**
 * File Input/Output
 */
package com.eamonn_sweeney.app.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class FileIO {

	private File dataDir;
	private File employeesFile;
	private File departmentsFile;
	private File helpFile;

	/**
	 * 
	 */
	public FileIO() {
		setFilePaths(new File("src/com/eamonn_sweeney/app/data"));
	}

	/**
	 * @param dataDir
	 */
	public FileIO(File dataDir) {
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
	 * Check if data files exists or if it is empty and if so generate some data.
	 * File.length() returns 0L if a file is empty or does not exist
	 */
	public void doIntegrityCheck() {	
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
		ArrayList<Employee> emps = new ArrayList<>();
			
		emps.add(new Developer(1, new Name("Mr", "Donald", "Duck"), 0, 
					LocalDate.now(), "---"));
		emps.add(new Developer(2, new Name("Mr", "Michael", "Mouse"), 0, 
					LocalDate.now(), "---", Level.TWO));
		emps.add(new Manager(3, new Name("Ms", "Minnie", "Mouse"), 0, 
					LocalDate.now(), "---", 4, 60000, .1));
		emps.add(new Manager(4, new Name("Mr", "Daffy", "Duck"), 0, 
					LocalDate.now(), "---", 4, 60000, .1));
			
		writeEmployeesToFile(emps);
	}
	
	/**
	 * 
	 */
	private void generateInitialDepartmentData() {
		ArrayList<Department> depts = new ArrayList<>();
			
		depts.add(new Department(1, "Legal", 11));
		depts.add(new Department(2, "HR", 12));
		depts.add(new Department(3, "DevOps", 10));
		depts.add(new Department(4, "Development", 8));
		
		writeDepartmentsToFile(depts);
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
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (ClassNotFoundException e) {
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
