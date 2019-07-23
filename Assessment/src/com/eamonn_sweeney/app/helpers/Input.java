/**
 * Input static methods
 */
package com.eamonn_sweeney.app.helpers;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class Input {

	private static Scanner input = new Scanner(System.in);
	
	/**
	 * 
	 */
	public static void close() {
		if (input != null) {
			input.close();
		}
	}
	
	/**
	 * 
	 */
	public static int getInteger(String msg) {
		return getIntegerInput(msg);
	}
	
	/**
	 * 
	 */
	public static int getInteger(String msg, int min) {
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
	public static int getInteger(String msg, int min, int max) {
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
	public static double getDouble(String msg) {
			return getDoubleInput(msg);
	}
	
	/**
	 * 
	 */
	public static double getDouble(String msg, double min) {
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
	public static double getDouble(String msg, double min, double max) {
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
	private static int getIntegerInput(String msg) {
		boolean isValidInput = false;
		int x = 0;
		
		do {
			try {
				System.out.println(msg);
				x = input.nextInt();
				isValidInput = true;
			} catch(InputMismatchException e) {
				System.out.println("Input must be an integer.");
				input.nextLine(); // flush remaining buffer '\n'
			}
		} while (!isValidInput);
		
		return x;
	}
	
	/**
	 * 
	 */
	private static double getDoubleInput(String msg) {
		boolean isValidInput = false;
		double x = 0;
		
		do {
			try {
				System.out.println(msg);
				x = input.nextDouble();
				isValidInput = true;
			} catch(InputMismatchException e) {
				System.out.println("Input must be a decimal number.");
				input.nextLine(); // flush remaining buffer '\n'
			}
		} while (!isValidInput);
		
		return x;
	}

	/**
	 * 
	 */
	private static boolean isNotLessThan(int min, int x) {
		if (x < min) {
			System.out.println("Input cannot be less than " + min);
			return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 */
	private static boolean isNotGreaterThan(int max, int x) {
		if (x > max) {
			System.out.println("Input cannot be more than " + max);
			return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 */
	private static boolean isNotLessThan(double min, double x) {
		if (x < min) {
			System.out.println("Input cannot be less than " + min);
			return false;
		} 
		
		return true;
	}
	
	/**
	 * 
	 */
	private static boolean isNotGreaterThan(double max, double x) {
		if (x > max) {
			System.out.println("Input cannot be more than " + max);
			return false;
		} 
		
		return true;
	}
	
}
