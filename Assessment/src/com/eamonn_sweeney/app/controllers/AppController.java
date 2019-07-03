/**
 * AppController - The Application Controller.
 */
package com.eamonn_sweeney.app.controllers;

import java.util.ArrayList;

import com.eamonn_sweeney.app.models.Department;
import com.eamonn_sweeney.app.models.Employee;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class AppController {
	
	private ArrayList<Employee> employees;
	private ArrayList<Department> departments;
	
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
