/**
 * Main - contains the applications main() method.
 */

/*
 * 	Assessment 4520-323 - Create an Event Driven Program using Java.
 * 
 * 
 * 	Task A
 * 	Create all classes for the application using Inheritance, Abstraction, 
 * 	Composition and Interfaces where you deem necessary.
 * 
 * 	To start create a Name class which will consist of three variables title, 
 * 	first name, and last name. Create appropriate constructors, getter and 
 * 	setters add a toString method. 
 * 	Create a test class and ensure all is working as expected.
 * 
 * 	Next create a Department class which will consist of a department ID, 
 * 	Department name, and number of employees. Create appropriate constructors, 
 * 	getter and setters add a toString method, add an equal's method.
 * 	Create a test class and ensure all is working as expected.
 *  
 *  Next create an Employee class which will be abstract (you won't be able to
 *  instantiate an Employee). Followed by a Manager class, and the Developer 
 *  class both of which will inherit from Employee. 
 *  All classes should have appropriate constructors, getter and setters, and 
 *  also a toString method and an equal's method.
 *  Each new employee added will have their own unique id.
 *  
 *  The Employee Class will be abstract and have;
 *  	Unique Id
 *  	Name
 *  	Department
 *  	Date Started (Just use Java's own built in classes for this)
 *  	Phone Number (use String)
 *  	Monthly Pay
 *  
 *  The Manager Class will have;
 *  	Number of Staff
 *  	Salary
 *  	Bonus (Which is a percentage)
 *  
 *  The Developer Class will have;
 *  	Level, e.g. Developer level 1 or Developer level 2 and Developer level 3
 *  	Hourly Rate
 *  
 *  Create a Holiday class which will consist of a start date, end date, and an 
 *  associated Employee
 *  
 *  To start first draw out your class diagrams, this will give you a good 
 *  understanding as to the connection between all the classes. Next create 
 *  tester classes; you will want to show creating new objects for both the 
 *  Manager and the Developer and Holiday classes. Show that the getter and 
 *  setters work and show that the toString method prints out all details for 
 *  each of the different employees. Test the equal's method.
 *  
 *  Both managers and developers share some characteristics such as booking
 *  holidays, managers are free to book any calendar date while developers must 
 *  get managers permission for chosen dates, also holidays cannot exceed over 2 
 *  weeks.
 *  
 *  Both managers and developers must put in a time sheet recording their weekly 
 *  hours (a normal working week is 35 hours) which is used to calculate their 
 *  weekly pay.
 *  
 *  Managers may work overtime but do not receive any overtime pay, developers 
 *  also work overtime but receive time and half. Managers wages are calculated 
 *  by their monthly salary plus bonus, Developer level 1 receive €17 p/hour, 
 *  Developer level 2 receive €18 p/hour, Developer level 3 receive €19.50 
 *  p/hour. 
 *  
 *  Employees and Managers can put in a request to move Department. For a 
 *  Manager to move there can only be 2 managers per department and for an 
 *  Employee to move there must be less than 14 in the department.
 *  
 *  Next create another class with a menu this class will be the Main Menu. 
 *  The menu should allow a user depending on their number choice;
 *  	1. List all Employees
 *  	2. Add a new Employee; with this choice the user should then be asked 
 *  	if they want to either add a Manager or a Developer
 *  	3. Edit an Employee by id
 *  	4. Delete an Employee by id
 *  	5. View all Managers
 *  	6. View all Developers
 *  	7. View number of staff within a department
 *  	8. Sub-Menu holiday booking
 *  	9. Sub-Menu payment
 *  	10. Exit Menu
 *  
 *  With the Menu class ensure you choose the correct selection statements and
 *  appropriate methods for each action. As you will be working with inheritance 
 *  you will also need to know how to use the instanceof method to distinguish 
 *  between the different Employees.
 *  
 *  All Employees should be stored in a list the same should be done for 
 *  departments.
 *  
 *  When the application starts up it should read all information from a file, 
 *  when the application is closing it should write all data back out to file.
 *  
 *  
 *  Task B
 *  Create on-screen help to assist the users of the application. This should 
 *  also be a document that is a plain human readable file, this document should 
 *  be readable from the application through the console when the user requires 
 *  information on how to use the application as well as available offline as an 
 *  ordinary text document.
 *  
 *  Also create documentation for the support and maintenance of the application.
 *  
 *  
 *  Task C
 *  Use the agreed standard for naming, comments, and code layout (see below). 
 *  Also validate all data that comes from inputs. Identify and implement 
 *  opportunities for error handling and reporting.
 *  
 *  
 *  Task D
 *  In this task you are required to test the program you have created and 
 *  provide documentation.
 *  1. Prepare a test strategy
 *  2. Make effective use of the debugging tool available in the IDE
 *  3. Select suitable test data and determine expected test results
 *  4. Record actual test results to enable comparison with expected results
 *  5. Analyse actual test results against expected results to identify 
 *  discrepancies
 *  6. Investigate test discrepancies to identify and rectify their causes
 *  
 *  
 *  Coding Standard
 *  All methods must be commented using Java doc standard, any methods that may
 *  need extra comments to allow other developers a better understanding of its 
 *  function can be added within the method.
 *  Method names and variable names must all be written in camel case notation.
 *  Package names will be written in lower case with an underscore separating 
 *  words.
 *  Class names and constructors, along with the project name will all be 
 *  written in Pascal Case.
 *  Formatting will be essential all code must be clean, tidy, and readable. 
 *  Opening braces ( { ) will be placed at the end of the line and not on a new 
 *  line. 
 */
package com.eamonn_sweeney;

import java.time.LocalDate;
import java.util.ArrayList;

import com.eamonn_sweeney.app.controller.Application;
import com.eamonn_sweeney.app.controller.FileIO;
import com.eamonn_sweeney.app.model.Department;
import com.eamonn_sweeney.app.model.Developer;
import com.eamonn_sweeney.app.model.Employee;
import com.eamonn_sweeney.app.model.Manager;
import com.eamonn_sweeney.app.model.Name;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class Main {
	
	public static void main(String[] args) {
		Application app = new Application();
		app.run();

		ArrayList<Employee> employees = new ArrayList<>();
		Developer dev1 = new Developer(1, new Name("Mr", "Donald", "Duck"), 0, 
				LocalDate.now(), "---");
		Developer dev2 = new Developer(2, new Name("Mr", "Michael", "Mouse"), 0, 
				LocalDate.now(), "---");
		Manager man1 = new Manager(3, new Name("Ms", "Minnie", "Mouse"), 0, 
				LocalDate.now(), "---", 4, 60000, .1);
		employees.add(dev1);
		employees.add(dev2);
		employees.add(man1);
		
		ArrayList<Department> departments = new ArrayList<>();
		departments.add(new Department(1, "DevOps", 2));
		departments.add(new Department(2, "Development", 4));
		departments.add(new Department(3, "HR", 8));
		
		FileIO files = new FileIO();
		files.writeEmployeesToFile(employees);
		files.writeDepartmentsToFile(departments);
		
		ArrayList<Employee> employees2 = files.readEmployeesFromFile();
		for (Employee emp : employees2) {
			System.out.println(emp);
		}
		
		System.out.println();
		
		ArrayList<Department> departments2 = files.readDepartmentsFromFile();
		for (Department dept : departments2) {
			System.out.println(dept);
		}
		
		System.out.println();
		
		String helpFile = files.readHelpFile();
		System.out.println(helpFile);
	}
	
	
}
