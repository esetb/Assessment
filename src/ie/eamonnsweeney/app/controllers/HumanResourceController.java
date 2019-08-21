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
	private int vacantManagerPositions = 0;
	private int vacantEmployeePositions = 0;
	
	public HumanResourceController (DataController dataController, InputController inputController) {
		this.departments = dataController.getDepartments();
		this.employees = dataController.getEmployees();
		this.inputController = inputController;
		this.nextEmployeeIdNum = (getHighestEmployeeIdNum() + 1);
		this.setVacantPositions();
	}

	public void listDepartments() {
		System.out.println("\n*** Departments ***");
		for (Department e : departments) {
			System.out.println(e);
		}
	}
	
	public void listEmployeesByDepartmentId() {
		int deptIdNum = inputController.getInteger("Department ID (1-3):", 1, 3);
		boolean departmentFound = false;
		
		for (Department department : departments) {
			if (department.getIdNum() == deptIdNum) {
				departmentFound = true;
				ArrayList<Manager> managers = new ArrayList<>();
				ArrayList<Developer> developers = new ArrayList<>();
				
				for (Employee employee : employees) {
					if (employee.getDeptIdNum() == deptIdNum) {
						if (employee instanceof Manager) {
							managers.add((Manager) employee);
						} else {
							developers.add((Developer) employee);
						}
					}
				}
				System.out.printf("\n*** View Department ***\nID: %d\nName: %s\nEmployees: %d\n",
						department.getIdNum(), department.getName(), department.getNumEmployees());
				if (managers.size() > 0) {
					System.out.println("Managers:");
					for (Manager manager : managers) {
						System.out.println("\t" + manager.getName().getTitle() 
								+ " " + manager.getName().getFirstName() 
								+ " " + manager.getName().getLastName());
					}
				}
				if (developers.size() > 0) {
					System.out.println("Developers:");
					for (Developer developer : developers) {
						System.out.println("\t" + developer.getName().getTitle() 
								+ " " + developer.getName().getFirstName() 
								+ " "+ developer.getName().getLastName());
					}
				}
			}
		}
		
		if (!departmentFound) {
			System.out.println("Error: No department exists with that id number.");
		}
	}
	
	/**
	 * List employees.
	 */
	public void listEmployees() {
		System.out.println("\n*** Employees ***");
		for (Employee e : employees) {
			System.out.print(((e instanceof Manager) ? "Manager" : "Developer") + ": ");
			System.out.println(e);
		}
	}
	
	/**
	 * List managers.
	 */
	public void listManagers() {
		System.out.println("\n*** Managers ***");
		for (Employee e : employees) {
			if (e instanceof Manager) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * List developers.
	 */
	public void listDevelopers() {
		System.out.println("\n*** Developers ***");
		for (Employee e : employees) {
			if (e instanceof Developer) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * Adds the employee.
	 */
	public void addEmployee() {
		String menuTitle = "Add Employee";
		String[] menuItems = {
				"Add Manager", 
				"Add Developer", 
				"Return to Main Menu"
				};
		Menu menu = new Menu(inputController, menuTitle, menuItems);
		boolean exitMenu = false;
		
		do {
			menu.display();
			switch (menu.getOption()) {
			case 1:
				addManager();
				break;
			case 2:
				addDeveloper();
				break;
			case 3:
				return;
			}
		} while (!exitMenu);
		
	}
	
	/**
	 * Adds a new manager.
	 */
	public void addManager() {
		if (canAddManager()) {
			ManagerController mc = new ManagerController(departments, employees, inputController);
			employees.add(mc.createNewManager(nextEmployeeIdNum));
			nextEmployeeIdNum++;
			System.out.println("Manager added.");
		} else {
			System.out.println("Cannot add a Manager - there are no managerial vacancies.");
		}
	}
	

	/**
	 * Adds a new developer.
	 */
	public void addDeveloper() {
		if (canAddEmployee()) {
			DeveloperController dc = new DeveloperController(departments, employees, inputController);
			employees.add(dc.createNewDeveloper(nextEmployeeIdNum));
			nextEmployeeIdNum++;
			System.out.println("Manager added.");
		} else {
			System.out.println("Cannot add a developer - there are no vacancies at this time.");
		}
	}
	

	/**
	 * Edits the employee.
	 */
	public void editEmployeeById() {
		int max = (nextEmployeeIdNum - 1);
		int id = inputController.getInteger("Employee ID to edit (1-" + max + "): ", 1, max);
		boolean idFound = false;
		
		for (Employee e : employees) {
			if (e.getIdNum() == id) {
				if (e instanceof Manager) {
					ManagerController mc = new ManagerController(departments, employees, inputController);
					mc.edit(e);
				} else {
					DeveloperController dc = new DeveloperController(departments, employees, inputController);
					dc.edit(e);
				}
				idFound = true;
				break;
			}
		}
		
		if (!idFound) {
			System.out.println("Employee ID: " + id + " does not exist.");
		}
	}
	
	/**
	 * Delete employee.
	 */
	public void deleteEmployeeById() {
		int max = (nextEmployeeIdNum - 1);
		int id = inputController.getInteger("Employee ID to delete (1-" + max + "): ", 1, max);
		boolean employeeFound = false;
		
		for (Employee employee : employees) {
			if (employee.getIdNum() == id) {
				for (Department department : departments) {
					if (department.getIdNum() == employee.getDeptIdNum()) {
						if (employee instanceof Manager) {
							vacantManagerPositions++;
							department.setNumManagers(department.getNumManagers() -1);
						}
						vacantEmployeePositions++;
						department.setNumEmployees(department.getNumEmployees() -1);
						break;
					}
				}
				employees.remove(employee);
				System.out.println("Employee with ID: " + id + ", deleted successfully.");
				employeeFound = true;
				break;
			}
		}
		
		if (!employeeFound) {
			System.out.println("Employee ID: " + id + " does not exist.");
		}
	}

	/**
	 * Gets the highest employee id num.
	 *
	 * @return the highest employee id num
	 */
	private int getHighestEmployeeIdNum() {
		int highestIdNum = 0;
		int idNum = 0;
		
		for (Employee e : employees) {
			idNum = e.getIdNum();
			if (idNum > highestIdNum) {
				highestIdNum = idNum;
			}
		}
		
		return highestIdNum;
	}
	
	private boolean canAddEmployee() {
		return (vacantEmployeePositions > 0);
	}


	private boolean canAddManager() {
		return (vacantManagerPositions > 0);
	}
	
	private void setVacantPositions() {
		int numMangersInDepartment = 0;
		int numEmployeesInDepartment = 0;
		
		for (Department department : departments) {
			numMangersInDepartment = department.getNumManagers();
			numEmployeesInDepartment = department.getNumEmployees();
			this.vacantManagerPositions += (department.getMaxManagers() - numMangersInDepartment);
			this.vacantEmployeePositions += (department.getMaxEmployees() - numEmployeesInDepartment);
		}
	
	}
	
}
