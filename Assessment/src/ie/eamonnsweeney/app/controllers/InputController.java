/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import java.util.Scanner;

/**
 * @author Eamonn A. Sweeney
 *
 */
public class InputController {
	private static Scanner input = new Scanner(System.in);
	
	/**
	 * 
	 */
	public void close() {
		if (input != null) {
			input.close();
		}
	}
	
	/**
	 * 
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
				x = Integer.parseInt(getString(msg));
				isValidInput = true;
			} catch(NumberFormatException e) {
				System.out.println("Input must be an integer.");
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
				x = Double.parseDouble(getString(msg));
				isValidInput = true;
			} catch(NumberFormatException e) {
				System.out.println("Input must be a decimal value.");
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
