/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Menu;
import ie.eamonnsweeney.app.views.MainMenuView;


// TODO: Auto-generated Javadoc
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
	
	/** The help. */
	private String help;

	/** The employees controller. */
	private EmployeesController employeesController;

	/** The departments controller. */
	private DepartmentsController departmentsController;
	
	/** The main menu view. */
	private MainMenuView mainMenuView;
	
	/**
	 * Instantiates a new application controller.
	 */
	public ApplicationController() {
		
		this.inputController = new InputController();
		this.dataController = new DataController();
		
		this.help = dataController.getHelp();
		
		this.employeesController = new EmployeesController(dataController, inputController);
		this.departmentsController = new DepartmentsController(dataController, inputController);

		this.mainMenuView = new MainMenuView(departmentsController, employeesController, 
				inputController, help);
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
