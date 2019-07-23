/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.helpers.Input;
import ie.eamonnsweeney.app.models.Manager;

/**
 * @author Eamonn A. Sweeney
 *
 */
public class ManagerController extends EmployeeController {
	
	private int numStaff;
	private double salary;
	private double bonus;

	/**
	 * 
	 */
	public Manager createNewManager(int idNum) {
		super.inputData();
		this.inputNumStaff();
		this.inputSalary();
		this.inputBonus();
		return new Manager(idNum, super.getName(), super.getDeptIdNum()
				, super.getDateStarted(), super.getPhoneNum()
				, this.numStaff, this.salary, this.bonus);
	}

	/**
	 * 
	 */
	private void inputNumStaff() {
		this.numStaff = Input.getInteger("Number of Staff (1-14): ", 1, 14);
	}
	
	/**
	 * 
	 */
	private void inputSalary() {
		this.salary = Input.getDouble("Salary (25000-65000): ", 25000, 65000);
	}
	
	/**
	 * 
	 */
	private void inputBonus() {
		this.bonus = Input.getDouble("Bonus % (0.0-1.0): ", 0.0, 1.0);
	}
	
}
