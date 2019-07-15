/**
 * 
 */
package com.eamonn_sweeney.app.controller;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class ConsoleInputController {

	private Scanner input;
	
	/**
	 * 
	 */
	public ConsoleInputController() {
		this.input = new Scanner(System.in);
	}
	
	/**
	 * 
	 */
	public void close() {
		input.close();
	}
	
	/**
	 * 
	 */
	public int getInteger(String msg) {
			return getIntegerInput(msg);
	}
	
	/**
	 * 
	 */
	public int getInteger(String msg, int min) {
		boolean isValidInput = false;
		int x = 0;
		
		do {
			x = getIntegerInput(msg);
			isValidInput = isNotLessThan(min, x); 
		} while (!isValidInput);
		
		return x;
	}

	/**
	 * 
	 */
	public int getInteger(String msg, int min, int max) {
		boolean isValidInput = false;
		int x = 0;
		
		do {
			x = getIntegerInput(msg);
			isValidInput = (isNotLessThan(min, x) && isNotGreaterThan(max, x));
		} while (!isValidInput);
		
		return x;
	}
	
	/**
	 * 
	 */
	public double getDouble(String msg) {
			return getDoubleInput(msg);
	}
	
	/**
	 * 
	 */
	public double getDouble(String msg, double min) {
		boolean isValidInput = false;
		double x = 0;
		
		do {
			x = getDoubleInput(msg);
			isValidInput = isNotLessThan(min, x); 
		} while (!isValidInput);
		
		return x;
	}

	/**
	 * 
	 */
	public double getDouble(String msg, double min, double max) {
		boolean isValidInput = false;
		double x = 0;
		
		do {
			x = getDoubleInput(msg);
			isValidInput = (isNotLessThan(min, x) && isNotGreaterThan(max, x));
		} while (!isValidInput);
		
		return x;
	}
	
	/**
	 * 
	 */
	private int getIntegerInput(String msg) {
		boolean isValidInput = false;
		int x = 0;
		
		do {
			try {
				System.out.println(msg);
				x = input.nextInt();
				isValidInput = true;
			} catch(InputMismatchException e) {
				System.out.println("Input must be an integer.");
				input.nextLine();
			}
		} while (!isValidInput);
		
		return x;
	}
	
	/**
	 * 
	 */
	private double getDoubleInput(String msg) {
		boolean isValidInput = false;
		double x = 0;
		
		do {
			try {
				System.out.println(msg);
				x = input.nextDouble();
				isValidInput = true;
			} catch(InputMismatchException e) {
				System.out.println("Input must be a decimal number.");
				input.nextLine();
			}
		} while (!isValidInput);
		
		return x;
	}

	/**
	 * 
	 */
	private boolean isNotLessThan(int min, int x) {
		if (x < min) {
			System.out.println("Input cannot be less than " + min);
			return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 */
	private boolean isNotGreaterThan(int max, int x) {
		if (x > max) {
			System.out.println("Input cannot be more than " + max);
			return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 */
	private boolean isNotLessThan(double min, double x) {
		if (x < min) {
			System.out.println("Input cannot be less than " + min);
			return false;
		} 
		
		return true;
	}
	
	/**
	 * 
	 */
	private boolean isNotGreaterThan(double max, double x) {
		if (x > max) {
			System.out.println("Input cannot be more than " + max);
			return false;
		} 
		
		return true;
	}
	
}
