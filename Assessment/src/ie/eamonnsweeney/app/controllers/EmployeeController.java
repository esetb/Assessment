/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Employee;


/**
 * The Class EmployeeController.
 *
 * @author Eamonn A. Sweeney
 */
public abstract class EmployeeController {

	/** The employee. */
	private Employee employee;
	
	/** The departments. */
	private ArrayList<Department> departments;
	
	/** The max dept id num. */
	private int maxDeptIdNum;
	
	/** The input controller. */
	protected InputController inputController;
	
	/**
	 * Instantiates a new employee controller.
	 *
	 * @param departments the departments
	 * @param maxDeptIdNum the max dept id num
	 * @param inputController the input controller
	 */
	public EmployeeController(ArrayList<Department> departments, int maxDeptIdNum, 
			InputController inputController) {
		this.departments = departments;
		this.maxDeptIdNum = maxDeptIdNum;
		this.inputController = inputController;
	}
	
	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	protected void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * Input title.
	 */
	protected void inputTitle() {
		String title = inputController.getString("Title: ");	
		this.employee.getName().setTitle(title);
	}
	
	/**
	 * Input first name.
	 */
	protected void inputFirstName() {
		String firstName = inputController.getString("First Name: ");	
		this.employee.getName().setFirstName(firstName);
	}
	
	/**
	 * Input last name.
	 */
	protected void inputLastName() {
		String lastName = inputController.getString("Last Name: ");	
		this.employee.getName().setLastName(lastName);
	}
	
	/**
	 * Input dept id num.
	 */
	protected void inputDeptIdNum() {
		int deptIdNum = inputController.getInteger("Department ID (1-" 
				+ maxDeptIdNum + "): ", 1, maxDeptIdNum);
		/* todo: is dept assignment legal.
		 * 
		 * listDepartmentVacancies();
		 * 
		 * 
		 */
		this.employee.setDeptIdNum(deptIdNum);
	}
	
	/**
	 * Input date started.
	 */
	protected void inputDateStarted() {
		//TODO: sanity checking valid date - no feb 31
		int year = inputController.getInteger("Year Started (2000-2019): ", 2000, 2019);
		int month = inputController.getInteger("Month Started (1-12): ", 1, 12);
		int day = inputController.getInteger("Day Started (1-31):", 1, 31);
		this.employee.setDateStarted(LocalDate.of(year, month, day));
	}
	
	/**
	 * Input phone num.
	 */
	protected void inputPhoneNum() {
		String phoneNum = inputController.getString("Phone #: ");	
		this.employee.setPhoneNum(phoneNum);	
	}
	
	/**
	 * Edits the employee data.
	 *
	 * @param menuOption the menu option
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
	 * Edits the.
	 *
	 * @param employee the employee
	 */
	protected abstract void edit(Employee employee);
	
}
