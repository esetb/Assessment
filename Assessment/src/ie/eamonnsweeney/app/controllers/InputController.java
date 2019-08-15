/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import java.util.Scanner;


/**
 * The Class InputController.
 *
 * @author Eamonn A. Sweeney
 */
public class InputController {
	
	/** The input. */
	private static Scanner input = new Scanner(System.in);
	
	/**
	 * Close.
	 */
	public void close() {
		if (input != null) {
			input.close();
		}
	}
	
	/**
	 * Gets a string input - cannot be empty.
	 *
	 * @param msg the msg
	 * @return the string
	 */
	public String getString(String msg) {
		boolean isValidInput = false;
		String s = null;
		
		do {
			System.out.println(msg);
			s = input.nextLine();
			if (s.equals("")) {
				System.out.println("Input cannot be empty, please enter a value.");
			} else {
				isValidInput = true;
			}
		} while (!isValidInput);
		
		return s;
	}
	
	/**
	 * Gets an integer.
	 *
	 * @param msg the msg
	 * @return the integer
	 */
	public int getInteger(String msg) {
		return getIntegerInput(msg);
	}
	
	/**
	 * Gets an integer with a minimum value.
	 *
	 * @param msg the msg
	 * @param min the min
	 * @return the integer
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
	 * Gets an integer between two values min-max.
	 *
	 * @param msg the msg
	 * @param min the min
	 * @param max the max
	 * @return the integer
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
	 * Gets a double.
	 *
	 * @param msg the msg
	 * @return the double
	 */
	public double getDouble(String msg) {
			return getDoubleInput(msg);
	}
	
	/**
	 * Gets a double with a minimum value
	 *
	 * @param msg the msg
	 * @param min the min
	 * @return the double
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
	 * Gets a double between two values min-max
	 *
	 * @param msg the msg
	 * @param min the min
	 * @param max the max
	 * @return the double
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
	 * Gets the integer input.
	 *
	 * @param msg the msg
	 * @return the integer input
	 */
	private int getIntegerInput(String msg) {
		boolean isValidInput = false;
		int x = 0;
		
		do {
			try {
				x = Integer.parseInt(getString(msg));
				isValidInput = true;
			} catch(NumberFormatException e) {
				System.out.println("Input must be an integer.");
			}
		} while (!isValidInput);
		
		return x;
	}
	
	/**
	 * Gets the double input.
	 *
	 * @param msg the msg
	 * @return the double input
	 */
	private double getDoubleInput(String msg) {
		boolean isValidInput = false;
		double x = 0;
		
		do {
			try {
				x = Double.parseDouble(getString(msg));
				isValidInput = true;
			} catch(NumberFormatException e) {
				System.out.println("Input must be a decimal value.");
			}
		} while (!isValidInput);
		
		return x;
	}

	/**
	 * Checks if is not less than.
	 *
	 * @param min the min
	 * @param x the x
	 * @return true, if is not less than
	 */
	private boolean isNotLessThan(int min, int x) {
		if (x < min) {
			System.out.println("Input cannot be less than " + min);
			return false;
		}
		
		return true;
	}
	
	/**
	 * Checks if is not greater than.
	 *
	 * @param max the max
	 * @param x the x
	 * @return true, if is not greater than
	 */
	private boolean isNotGreaterThan(int max, int x) {
		if (x > max) {
			System.out.println("Input cannot be more than " + max);
			return false;
		}
		
		return true;
	}
	
	/**
	 * Checks if is not less than.
	 *
	 * @param min the min
	 * @param x the x
	 * @return true, if is not less than
	 */
	private boolean isNotLessThan(double min, double x) {
		if (x < min) {
			System.out.println("Input cannot be less than " + min);
			return false;
		} 
		
		return true;
	}
	
	/**
	 * Checks if is not greater than.
	 *
	 * @param max the max
	 * @param x the x
	 * @return true, if is not greater than
	 */
	private boolean isNotGreaterThan(double max, double x) {
		if (x > max) {
			System.out.println("Input cannot be more than " + max);
			return false;
		} 
		
		return true;
	}
	
}
