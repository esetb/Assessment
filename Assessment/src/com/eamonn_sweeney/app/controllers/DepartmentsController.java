/**
 * 
 */
package com.eamonn_sweeney.app.controllers;

import java.io.File;
import java.util.ArrayList;

import com.eamonn_sweeney.app.helpers.FileIO;
import com.eamonn_sweeney.app.models.Department;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class DepartmentsController {

	private File dataFile;
	private ArrayList<Department> departments;
	private int nextIdNum;
	private int menuOption;
	
	/**
	 * 
	 */
	public DepartmentsController() {
		this.dataFile = new File("src/com/eamonn_sweeney/app/data/departments.dat");
		this.departments = loadData();
		this.nextIdNum = getHighestIdNum();
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
	 * 
	 */
	private ArrayList<Department> loadData() {
		ArrayList<Department> departments = new ArrayList<>();
		
		// File.length() returns 0L if a file is empty or does not exist.
		if (dataFile.length() == 0) {
			departments.add(new Department(1, "DevOps", 8));
			departments.add(new Department(2, "Development", 4));
			departments.add(new Department(3, "Data Analytics", 6));
			departments.add(new Department(4, "Legal", 10));
			departments.add(new Department(5, "Human Resources", 12));
		} else {
			departments = readDataFromFile();
		}
		
		return departments;	
	}
	
	/**
	 * 
	 */
	private ArrayList<Department> readDataFromFile() {
		ArrayList<?> genericArrayListObject = FileIO.readArrayList(dataFile);
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
