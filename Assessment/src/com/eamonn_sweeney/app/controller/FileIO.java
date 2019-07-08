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
import java.util.ArrayList;

import com.eamonn_sweeney.app.model.Department;
import com.eamonn_sweeney.app.model.Employee;

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
