package ie.eamonnsweeney.app.controllers;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;


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
	
	/** The input controller. */
	protected InputController inputController;
	 
	/**
	 * Instantiates a new employee controller.
	 *
	 * @param departments the departments
	 * @param inputController the input controller
	 */
	public EmployeeController(ArrayList<Department> departments, InputController inputController) {
		this.departments = departments;
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
		boolean isValidDepartment = false;
		int deptIdNum;
		
		do {
			deptIdNum = inputController.getInteger("Department ID (1-3): ", 1, 3);
			for (Department department : departments) {
				if (department.getIdNum() == deptIdNum) {
					if (employee instanceof Manager) {
						if (department.getNumManagers() < department.getMaxManagers()) {
							isValidDepartment = true;
						} else {
							System.out.println("There are no managerial vacancies in " + department.getName() + ".");
						}
					} else {
						if (department.getNumEmployees() < department.getMaxEmployees()) {
							isValidDepartment = true;
						} else {
							System.out.println("There are no vacancies in " + department.getName() + ".");
						}
					}
				}
			}
		} while (!isValidDepartment);
		
		if (employee.getDeptIdNum() != 0) {
			// we are editing, not creating
			moveDepartments(employee.getDeptIdNum(), deptIdNum);
		}
		
		this.employee.setDeptIdNum(deptIdNum);
	}
	
	/**
	 * Move departments.
	 *
	 * @param oldDeptIdNum the old dept id num
	 * @param newDeptIdNum the new dept id num
	 */
	private void moveDepartments(int oldDeptIdNum, int newDeptIdNum) {
		if (oldDeptIdNum == newDeptIdNum) {
			return;
		}
		Department oldDepartment = null;
		Department newDepartment = null;
		
		for (Department department : departments) {
			if (department.getIdNum() == oldDeptIdNum) {
				oldDepartment = department;
			}
			if (department.getIdNum() == newDeptIdNum) {
				newDepartment = department;
			}
		}
		
		if (employee instanceof Manager) {
			oldDepartment.setNumManagers(oldDepartment.getNumManagers() - 1);
			newDepartment.setNumManagers(newDepartment.getNumManagers() + 1);
		}
		
		oldDepartment.setNumEmployees(oldDepartment.getNumEmployees() - 1);
		newDepartment.setNumEmployees(newDepartment.getNumEmployees() + 1);
	}

	/**
	 * Input date started.
	 */
	protected void inputDateStarted() {
		int daysInMonth = 0;
		int year = inputController.getInteger("Year Started (2000-2019): ", 2000, 2019);
		int month = inputController.getInteger("Month Started (1-12): ", 1, 12);
		
		switch (month) {
		case 1:
			daysInMonth = 31;
			break;
		case 2:
			daysInMonth = (Year.of(year).isLeap()) ? 29 : 28;
			break;
		case 3:
			daysInMonth = 31;
			break;
		case 4:
			daysInMonth = 30;
			break;
		case 5:
			daysInMonth = 31;
			break;
		case 6:
			daysInMonth = 30;
			break;
		case 7:
		case 8:
			daysInMonth = 31;
			break;
		case 9:
			daysInMonth = 30;
			break;
		case 10:
			daysInMonth = 31;
			break;
		case 11:
			daysInMonth = 30;
			break;
		case 12:
			daysInMonth = 31;
			break;
		}
		
		int day = inputController.getInteger("Day Started (1-" + daysInMonth + "):", 1, daysInMonth);
		
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
	 * Gets the employee menu items.
	 *
	 * @return the employee menu items
	 */
	protected String[] getEmployeeMenuItems() {
		String[] employeeMenuItems = {
				"Title: " + employee.getName().getTitle(),
				"First Name: " + employee.getName().getFirstName(),
				"Last Name: " + employee.getName().getLastName(),
				"Dept ID #: " + employee.getDeptIdNum(),
				"Date Started: " + employee.getDateStarted().toString(),
				"Phone #: " + employee.getPhoneNum(),	
		};
		
		return employeeMenuItems;
	}
	
	/**
	 * Merge string arrays.
	 *
	 * @param arrayA the array A
	 * @param arrayB the array B
	 * @return the string[]
	 */
	protected String[] mergeStringArrays(String[] arrayA, String[] arrayB) {
		String[] newArray = new String[arrayA.length + arrayB.length];
		int index = 0;
		
		for (int i = 0; i < arrayA.length; i++, index++) {
			newArray[index] = arrayA[i];
		}
		
		for (int i = 0; i < arrayB.length; i++, index++) {
			newArray[index] = arrayB[i];
		}
		
		return newArray;
	}
	
	/**
	 * Edits the employee.
	 *
	 * @param employee the employee
	 */
	protected abstract void edit(Employee employee);
	
}
