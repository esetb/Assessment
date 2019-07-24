/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import java.time.LocalDate;
import ie.eamonnsweeney.app.helpers.Input;
import ie.eamonnsweeney.app.models.Name;


/**
 * @author Eamonn A. Sweeney
 *
 */
public abstract class EmployeeController {

	private Name name;
	private int deptIdNum; 
	private LocalDate dateStarted;
	private String phoneNum;

	/**
	 * @return the name
	 */
	protected Name getName() {
		return name;
	}

	/**
	 * @return the deptIdNum
	 */
	protected int getDeptIdNum() {
		return deptIdNum;
	}

	/**
	 * @return the dateStarted
	 */
	protected LocalDate getDateStarted() {
		return dateStarted;
	}

	/**
	 * @return the phoneNum
	 */
	protected String getPhoneNum() {
		return phoneNum;
	}
	
	/**
	 * 
	 */
	protected void inputData() {
		System.out.println("Please enter the following information.");
		this.inputName();
		this.inputDeptIdNum();
		this.inputDateStarted();
		this.inputPhoneNum();
	}
	
	/**
	 * 
	 */
	private void inputName() {
		String title = Input.getString("Title: ");
		String fName = Input.getString("First Name: ");
		String lName = Input.getString("Surname: ");	
		this.name = new Name(title, fName, lName);
	}

	/**
	 * 
	 */
	private void inputDeptIdNum() {
		//TODO: get total departments for max
		this.deptIdNum = Input.getInteger("Department ID (1-100): ", 1, 100);	
	}
	
	/**
	 * 
	 */
	private void inputDateStarted() {
		//TODO: sanity checking valid date - no feb 31
		int year = Input.getInteger("Year Started (2000-2019): ", 2000, 2019);
		int month = Input.getInteger("Month Started (1-12): ", 1, 12);
		int day = Input.getInteger("Day Started (1-31):", 1, 31);
		this.dateStarted = LocalDate.of(year, month, day);
	}
	
	/**
	 * 
	 */
	private void inputPhoneNum() {
		this.phoneNum = Input.getString("Phone #: ");	
	}

}
