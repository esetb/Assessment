/**
 * 
 */
package ie.eamonnsweeney.app.models;

import ie.eamonnsweeney.app.controllers.InputController;

/**
 * @author Eamonn A. Sweeney
 *
 */
public class Menu {
	
	private InputController inputController;
	private String name;
	private String[] options;
	private String renderedMenu;
	
	/**
	 * 
	 */
	public Menu(InputController inputController, String name, String[] options) {
		this.inputController = inputController;
		this.name = name;
		this.options = options;
		renderMenu();
	}
	
	/**
	 * 
	 */
	public void display() {
		System.out.println(renderedMenu);
	}
	/**
	 * 
	 */
	public int getOption() {
		int numOptions = options.length;
		return inputController.getInteger("Enter menu option (1-" 
				+ numOptions + "): ", 1, numOptions);
	}
	
	/**
	 * 
	 */
	private void renderMenu() {
		renderedMenu = "\n" + name;
		for (int i = 0 ; i < options.length ; i++) {
			renderedMenu += ("\n" + (i + 1) + ". " + options[i]); 
		}
	}

}
