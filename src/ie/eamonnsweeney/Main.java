package ie.eamonnsweeney;

import ie.eamonnsweeney.app.controllers.ApplicationController;


/**
 * The Class Main.
 *
 * @author Eamonn A. Sweeney
 */
public class Main {
	
	/**
	 * The Application Entry Point.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		try {
			ApplicationController app = new ApplicationController();
			app.run();
		} catch (Exception e) {
			System.out.println("Unhandled Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
