/**
 * AppController - The Application Controller.
 */
package com.eamonn_sweeney.app.controller;

import java.util.ArrayList;

import com.eamonn_sweeney.app.model.Department;
import com.eamonn_sweeney.app.model.Employee;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class Application {
	
	private ArrayList<Employee> employees;
	private ArrayList<Department> departments;
	private int nextEmployeeIdNum;
	private int nextDepartmentIdNum;
	
	/**
	 * 
	 */
	public Application() {
		
	}
	
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
