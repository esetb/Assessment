/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Employee;


/**
 * @author Eamonn A. Sweeney
 *
 */
public abstract class EmployeeController {

	private Employee employee;
	private ArrayList<Department> departments;
	private int maxDeptIdNum;
	protected InputController inputController;
	
	/**
	 * 
	 */
	public EmployeeController(ArrayList<Department> departments, int maxDeptIdNum, 
			InputController inputController) {
		this.departments = departments;
		this.maxDeptIdNum = maxDeptIdNum;
		this.inputController = inputController;
	}
	
	/**
	 * 
	 */
	protected void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * 
	 */
	protected void inputTitle() {
		String title = inputController.getString("Title: ");	
		this.employee.getName().setTitle(title);
	}
	
	/**
	 * 
	 */
	protected void inputFirstName() {
		String firstName = inputController.getString("First Name: ");	
		this.employee.getName().setFirstName(firstName);
	}
	
	/**
	 * 
	 */
	protected void inputLastName() {
		String lastName = inputController.getString("Last Name: ");	
		this.employee.getName().setLastName(lastName);
	}
	
	/**
	 * 
	 */
	protected void inputDeptIdNum() {
		int deptIdNum = inputController.getInteger("Department ID (1-" 
				+ maxDeptIdNum + "): ", 1, maxDeptIdNum);
		// todo: is dept assignment legal.
		this.employee.setDeptIdNum(deptIdNum);
	}
	
	/**
	 * 
	 */
	protected void inputDateStarted() {
		//TODO: sanity checking valid date - no feb 31
		int year = inputController.getInteger("Year Started (2000-2019): ", 2000, 2019);
		int month = inputController.getInteger("Month Started (1-12): ", 1, 12);
		int day = inputController.getInteger("Day Started (1-31):", 1, 31);
		this.employee.setDateStarted(LocalDate.of(year, month, day));
	}
	
	/**
	 * 
	 */
	protected void inputPhoneNum() {
		String phoneNum = inputController.getString("Phone #: ");	
		this.employee.setPhoneNum(phoneNum);	
	}
	
	/**
	 * 
	 */
	protected void editEmployeeData(int menuOption) {
		switch (menuOption) {
		case 1:
			inputTitle();
			break;
		case 2:
			inputFirstName();
			break;
		case 3:
			inputLastName();
			break;
		case 4:
			inputDeptIdNum();
			break;
		case 5:
			inputDateStarted();
			break;
		case 6:
			inputPhoneNum();
			break;
		}
	}
	
	/**
	 * 
	 */
	protected abstract void edit(Employee employee);
	
}
