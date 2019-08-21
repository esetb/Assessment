package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.views.MainMenuView;

/**
 * The Class ApplicationController.
 *
 * @author Eamonn A. Sweeney
 */
public class ApplicationController {
	
	/** The input controller. */
	private InputController inputController;
	
	/** The data controller. */
	private DataController dataController;
	
	/** The main menu Controller. */
	private MainMenuView mainMenuView;
	
	/**
	 * Instantiates a new application controller.
	 */
	public ApplicationController() {
		this.inputController = new InputController();
		this.dataController = new DataController();
		this.mainMenuView = new MainMenuView(dataController, inputController);
	}
	
	/**
	 * Run the Application.
	 */
	public void run() {
		mainMenuView.display();
		dataController.saveData();
		inputController.close();
	}	

}
