/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;
import ie.eamonnsweeney.app.models.Menu;
import ie.eamonnsweeney.app.models.Name;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class ManagerController extends EmployeeController {

	private Manager manager;

	/**
	 * 
	 */
	public ManagerController(InputController inputController) {
		super(inputController);
	}
	
	/**
	 * 
	 */
	public Manager createNewManager(int idNum) {
		this.manager = new Manager(idNum, new Name("","",""), 0, null, null, 0, 0.0, 0.0);
		super.setEmployee((Employee) manager); 
		inputTitle();
		inputFirstName();
		inputLastName();
		inputDeptIdNum();
		inputDateStarted();
		inputPhoneNum();
		inputNumStaff();
		inputSalary();
		inputBonus();
		return manager;
	}

	/**
	 * 
	 */
	public void edit(Employee employee) {
		super.setEmployee(employee);
		this.manager = (Manager) employee;
		boolean exitMenu = false;
		int menuOption = 0;
		
		do {
			String menuTitle = "Edit Manager Menu";
			String[] menuItems = {
					"Title: " + employee.getName().getTitle(),
					"First Name: " + employee.getName().getFirstName(),
					"Last Name: " + employee.getName().getLastName(),
					"Dept ID #: " + employee.getDeptIdNum(),
					"Date Started: " + employee.getDateStarted().toString(),
					"Phone #: " + employee.getPhoneNum(),
					"Num Staff: " + manager.getNumStaff(),
					"Salary: " + manager.getSalary(),
					"Bonus: "  + manager.getBonus(), 
					"Done (return to main menu)"
					};
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
				editEmployeeData(menuOption);
				break;
			case 7:
				inputNumStaff();
				break;
			case 8:
				inputSalary();
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
	 * 
	 */
	private void inputNumStaff() {
		int numStaff = inputController.getInteger("Number of Staff (1-14): ", 1, 14);
		this.manager.setNumStaff(numStaff);
	}
	
	/**
	 * 
	 */
	private void inputSalary() {
		double salary = inputController.getDouble("Salary (25000-65000): ", 25000, 65000);
		this.manager.setSalary(salary);
	}
	
	/**
	 * 
	 */
	private void inputBonus() {
		double bonus = inputController.getDouble("Bonus % (0.0-1.0): ", 0.0, 1.0);
		this.manager.setBonus(bonus);
	}
	
}
