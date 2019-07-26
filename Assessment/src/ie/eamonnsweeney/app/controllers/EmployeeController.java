/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import java.time.LocalDate;
import ie.eamonnsweeney.app.helpers.Input;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Name;


/**
 * @author Eamonn A. Sweeney
 *
 */
public abstract class EmployeeController {

	private Employee employee;
	
	/**
	 * 
	 */
	protected Employee getEmployee() {
		return employee;
	}
	
	/**
	 * @return 
	 * 
	 */
	protected void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	/**
	 * 
	 */
	protected void inputName() {
		String title = Input.getString("Title: ");
		String fName = Input.getString("First Name: ");
		String lName = Input.getString("Surname: ");	
		this.employee.setName(new Name(title, fName, lName));
	}

	/**
	 * 
	 */
	protected void inputDeptIdNum() {
		//TODO: get total departments for max
		int deptIdNum = Input.getInteger("Department ID (1-100): ", 1, 100);
		this.employee.setDeptIdNum(deptIdNum);
	}
	
	/**
	 * 
	 */
	protected void inputDateStarted() {
		//TODO: sanity checking valid date - no feb 31
		int year = Input.getInteger("Year Started (2000-2019): ", 2000, 2019);
		int month = Input.getInteger("Month Started (1-12): ", 1, 12);
		int day = Input.getInteger("Day Started (1-31):", 1, 31);
		this.employee.setDateStarted(LocalDate.of(year, month, day));
	}
	
	/**
	 * 
	 */
	protected void inputPhoneNum() {
		String phoneNum = Input.getString("Phone #: ");	
		this.employee.setPhoneNum(phoneNum);	
	}

	/**
	 * 
	 */
	protected abstract void edit(Employee employee);
	
}
