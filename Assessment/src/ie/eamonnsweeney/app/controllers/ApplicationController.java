/**
 * 
 */
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
		
		this.mainMenuController = new MainMenuController(
				new DepartmentsController(dataController, inputController), 
				new EmployeesController(dataController, inputController), 
				dataController.getHelp(),
				inputController
				);
		
	}
	
	/**
	 * Run the Application.
	 */
	public void run() {
		mainMenuController.display();
		dataController.saveData();
		inputController.close();
	}	

}
