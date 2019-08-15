/**
 * 
 */
package ie.eamonnsweeney.app.models;

import ie.eamonnsweeney.app.controllers.InputController;


/**
 * The Class Menu.
 *
 * @author Eamonn A. Sweeney
 */
public class Menu {
	
	/** The input controller. */
	private InputController inputController;
	
	/** The name. */
	private String name;
	
	/** The options. */
	private String[] options;
	
	/**
	 * Instantiates a new menu.
	 *
	 * @param inputController the input controller
	 * @param name the name
	 * @param options the options
	 */
	public Menu(InputController inputController, String name, String[] options) {
		this.inputController = inputController;
		this.name = name;
		this.options = options;
	}
	
	/**
	 * Display.
	 */
	public void display() {
		String menuStr = "\n" + name;
		for (int i = 0 ; i < options.length ; i++) {
			menuStr += ("\n" + (i + 1) + ". " + options[i]); 
		}
		System.out.println(menuStr);
	}
	
	/**
	 * Gets the option.
	 *
	 * @return the option
	 */
	public int getOption() {
		int numOptions = options.length;
		return inputController.getInteger("Enter menu option (1-" 
				+ numOptions + "): ", 1, numOptions);
	}

}
