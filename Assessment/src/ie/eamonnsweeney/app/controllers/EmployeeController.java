package ie.eamonnsweeney.app.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Employee;


// TODO: Auto-generated Javadoc
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
	
	/** The employees. */
	private ArrayList<Employee> employees;
	
	/** The input controller. */
	protected InputController inputController;
	 
	/**
	 * Instantiates a new employee controller.
	 *
	 * @param departments the departments
	 * @param employees the employees
	 * @param inputController the input controller
	 */
	public EmployeeController(ArrayList<Department> departments, 
			ArrayList<Employee> employees,
			InputController inputController) {
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
		ArrayList<Department> availableDepartments = getAvailableDepartments();
		int[] validDepartmentIds = new int[availableDepartments.size()];
		for (int i = 0; i < validDepartmentIds.length; i++) {
			validDepartmentIds[i] = availableDepartments.get(i).getIdNum();
		}
		int max = availableDepartments.size();
		boolean isValidDeptId = false;
		int deptIdNum = 0;
		
		do {
			deptIdNum = inputController.getInteger("Department ID (1-" + max 
				+ "): ", 1, max);
			for (int i = 0; i < validDepartmentIds.length; i++) {
				if (deptIdNum == validDepartmentIds[i]) {
					isValidDeptId = true;
				}
			}
			if (!isValidDeptId) {
				System.out.println("Please enter a valid Department ID #.");
			}
		} while (!isValidDeptId);
		
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
	 * Gets the available departments.
	 *
	 * @return the available departments
	 */
	private ArrayList<Department> getAvailableDepartments() {
		ArrayList<Department> availableDepartments = new ArrayList<>();
		int numManagersInDepartment = 0;
		int numEmployeesInDepartment = 0;
		
		for (Department department : departments) {
			numManagersInDepartment = 0;
			numEmployeesInDepartment = 0;
			for (Employee employee : employees) {
				
			}
		}
		
		return availableDepartments;
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
	 * Edits the.
	 *
	 * @param employee the employee
	 */
	protected abstract void edit(Employee employee);
	
}
