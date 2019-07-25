/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.helpers.Input;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class ManagerController extends EmployeeController {
	
	private Manager manager;

	/**
	 * 
	 */
	public ManagerController(int idNum) {
		super((Employee) new Manager(idNum, null, 0, null, null, 0, 0.0, 0.0));
		this.manager = (Manager) getEmployee();
	}

	/**
	 * 
	 */
	public ManagerController(Employee employee) {
		super(employee);
		this.manager = (Manager) employee;
	}
	
	/**
	 * 
	 */
	public Manager createNewManager() {
		inputName();
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
	public void edit() {
		
		
	}
	
	/**
	 * 
	 */
	private void inputNumStaff() {
		int numStaff = Input.getInteger("Number of Staff (1-14): ", 1, 14);
		this.manager.setNumStaff(numStaff);
	}
	
	/**
	 * 
	 */
	private void inputSalary() {
		double salary = Input.getDouble("Salary (25000-65000): ", 25000, 65000);
		this.manager.setSalary(salary);
	}
	
	/**
	 * 
	 */
	private void inputBonus() {
		double bonus = Input.getDouble("Bonus % (0.0-1.0): ", 0.0, 1.0);
		this.manager.setBonus(bonus);
	}
	
}
