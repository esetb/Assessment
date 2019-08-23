package ie.eamonnsweeney.app.controllers;

import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;
import ie.eamonnsweeney.app.models.Menu;
import ie.eamonnsweeney.app.models.Name;


/**
 * The Class ManagerController.
 *
 * @author Eamonn A. Sweeney
 */
public class ManagerController extends EmployeeController {

	/** The manager. */
	private Manager manager;

	/**
	 * Instantiates a new manager controller.
	 *
	 * @param departments the departments
	 * @param inputController the input controller
	 */
	public ManagerController(ArrayList<Department> departments, InputController inputController) {
		super(departments, inputController);
	}
	
	/**
	 * Creates the new manager.
	 *
	 * @param idNum the id num
	 * @return the manager
	 */
	public Manager createNewManager(int idNum) {
		this.manager = new Manager(idNum, new Name("","",""), 0, null, null, 0, 0.0, 0.0);
		super.setEmployee((Employee) manager); 
		super.inputTitle();
		super.inputFirstName();
		super.inputLastName();
		super.inputDeptIdNum();
		super.inputDateStarted();
		super.inputPhoneNum();
		inputNumStaff();
		inputMonthlySalary();
		inputBonus();
		return manager;
	}

	/**
	 * Edits an employee data.
	 *
	 * @param employee the employee
	 */
	public void edit(Employee employee) {
		super.setEmployee(employee);
		this.manager = (Manager) employee;
		boolean exitMenu = false;
		int menuOption = 0;
		
		do {
			String menuTitle = "Edit Manager Menu";
			String[] managerMenuItems = {
					"Num Staff: " + manager.getNumStaff(),
					"Monthly Salary: " + manager.getMonthlySalary(),
					"Bonus: "  + manager.getBonus(), 
					"Done (return to main menu)"
			};
			String[] menuItems = super.mergeStringArrays(getEmployeeMenuItems(), managerMenuItems);
			Menu menu = new Menu(inputController, menuTitle, menuItems);
			
			menu.display();
			menuOption = menu.getOption();
			switch (menuOption) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				super.editEmployeeData(menuOption);
				break;
			case 7:
				inputNumStaff();
				break;
			case 8:
				inputMonthlySalary();
				break;
			case 9:
				inputBonus();
				break;
			case 10:
				exitMenu = true;
			}
		} while (!exitMenu);
		
	}
	
	/**
	 * Input num staff.
	 */
	private void inputNumStaff() {
		int numStaff = inputController.getInteger("Number of Staff (1-14): ", 1, 14);
		this.manager.setNumStaff(numStaff);
	}
	
	/**
	 * Input salary.
	 */
	private void inputMonthlySalary() {
		double monthlySalary = inputController.getDouble("Monthly Salary (3200-10000): ", 3200, 10000);
		this.manager.setMonthlySalary(monthlySalary);
	}
	
	/**
	 * Input bonus.
	 */
	private void inputBonus() {
		double bonus = inputController.getDouble("Bonus % (0.0-1.0): ", 0.0, 1.0);
		this.manager.setBonus(bonus);
	}
	
}
