package ie.eamonnsweeney.app.controllers;


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
	private MainMenuController mainMenuController;
	
	/**
	 * Instantiates a new application controller.
	 */
	public ApplicationController() {
		this.inputController = new InputController();
		this.dataController = new DataController();
		this.mainMenuController = new MainMenuController(dataController, inputController);
	}
	
	/**
	 * Run the Application.
	 */
	public void run() {
		mainMenuController.run();
		dataController.saveData();
		inputController.close();
	}	

}
