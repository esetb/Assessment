/**
 * AppController - The Application Controller.
 */
package com.eamonn_sweeney.app.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import com.eamonn_sweeney.app.models.Department;
import com.eamonn_sweeney.app.models.Developer;
import com.eamonn_sweeney.app.models.Employee;
import com.eamonn_sweeney.app.models.Name;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class AppController {
	
	private ArrayList<Employee> employees;
	private ArrayList<Department> departments;
	private int nextEmployeeIdNum;
	private int nextDepartmentIdNum;
	
	/**
	 * 
	 */
	public void run() {
		doSetUp();
		doMainLoop();
		doTearDown();
	}
	
	/**
	 * 
	 */
	private void doSetUp() {
		// load data - populate arraylists
		// get highest Employee idNum and set nextEmployeeIdNum
		// get highest Department idNum and nextDepartmentIdNum;
	}
	
	/**
	 * 
	 */
	private void doMainLoop() {
		// display menu
		// get user choice
		// call methods
	}
	
	/**
	 * 
	 */
	private void doTearDown() {
		// write data
		// close resources
		// exit
	}
	
}
