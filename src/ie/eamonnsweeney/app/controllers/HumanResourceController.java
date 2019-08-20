package ie.eamonnsweeney.app.controllers;

import java.util.ArrayList;

import ie.eamonnsweeney.app.models.Department;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;
import ie.eamonnsweeney.app.models.Menu;

public class HumanResourceController {
	
	private InputController inputController;
	private ArrayList<Department> departments;
	private ArrayList<Employee> employees;
	private int nextEmployeeIdNum;
	private int MAX_MANAGERS_PER_DEPARTMENT;
	private int MAX_EMPLOYEES_PER_DEPARTMENT;
	
	public HumanResourceController (ArrayList<Department> departments, 
			ArrayList<Employee> employees) {
		this.departments = departments;
		this.employees = employees;
	}
	
	public void requestDepartmentChange(Employee employee, int departmentId) {
		
	}
	
	public void terminateEmployment(Employee employee) {
		
	}
	
	private void setDepartmentVacancies( ) {

	}


	
}
