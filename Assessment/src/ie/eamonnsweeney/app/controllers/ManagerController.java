/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import ie.eamonnsweeney.app.helpers.Input;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;
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
