/**
 * 
 */
package com.eamonn_sweeney.app.controller;

import com.eamonn_sweeney.app.model.Developer.Level;

/**
 * @author Eamonn A. Sweeney
 *
 */
public class DeveloperController {
	
	InputController input;
	private Level level;
	
	/**
	 * 
	 * @param input
	 */
	public DeveloperController(InputController input) {
		this.input = input;
	}

	/**
	 * 
	 */
	public void inputData() {
		inputLevel();
	}

	/**
	 * 
	 */
	public void inputLevel() {
		
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}
	
}
