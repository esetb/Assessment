/**
 * Main - contains the applications main() method.
 */

/*
The Amazing Software Company has been growing at an extremely fast rate. The
company, which was a 3 man start-up in the beginning, now has over 400
employees to date working under several different departments. The pain point the
company is now facing is managing all employees. This ranges from new hires to
pay role.
At present each of these are done by two separate systems, by different people. The
company would like to streamline this into one system, making it easier to train staff
to work with this one system rather than two.
The system will be built in-house by the highly skilled work force that is already on
site. The system will be a straight forward console application.
Using Java you will create an application that will use Inheritance, Polymorphism,
Abstraction and Interfaces. The application will be used by the Amazing Software
Company. The application will be used to manage their employees and the different
departments.

Task A
Create all classes for the application using Inheritance, Abstraction, Composition and
Interfaces where you deem necessary.
To start, create a Name class which will consist of three variables: title, first name,
and last name. Create appropriate constructors, getters and setters and a toString
method. Create a test class and ensure all is working as expected.
Next create a Department class which will consist of a department ID, Department
name and number of employees. Create appropriate constructors, getters and
setters and a toString method. Also add an equals method. Create a test class and
ensure all is working as expected.
Note: Initialise three department objects for the purposes of this assignment. These
should be Development, QA and DevOps with 0 employees per department initially.

Next create an Employee class which will be abstract (you won’t be able to
instantiate an Employee). Followed by a Manager class and the Developer class
both of which will inherit from Employee. All classes should have appropriate
constructors, getters and setters, a toString method and an equals method. Each
new employee added will have their own unique id.
The Employee Class will be abstract and have:
Unique Id
Name
Department Id
Date Started (Just use Java’s own built in classes for this)
Phone Number (use String)
The Manager Class will have:
Monthly Salary
Bonus (Which is a percentage)
The Developer Class will have;
Level, e.g. Developer level 1 or Developer level 2 and Developer level 3
Hourly Rate
To start, first draw out your class diagrams. This will give you a good understanding
as to the connection between all the classes. Next create tester classes. You will
want to show creating new objects for both the Manager and Developer classes.
Show that the getters and setters work and show that the toString method prints out
all details for each of the different employees. Test the equals method.
Both managers and developers must put in a time sheet recording their weekly hours
which is used to calculate their weekly pay. A normal working week is 35 hours.
Managers may work overtime but do not receive any overtime pay. Developers also
work overtime but receive time and half. Managers wages are calculated by their
monthly salary plus bonus. Developer level 1 receives €17 p/hour, Developer level 2
receives €18 p/hour, Developer level 3 receives €19.50 p/hour. Employees and
Managers can put in a request to move Department. For a Manager to move there
can only be 2 managers per department and for an Employee to move there must be
less than 14 in the department.

Next create another class with a menu. This class will be the Main Menu. The menu
should show the following options to the user:
1. List all Employees
2. List all Departments
3. Add a new Employee (with this choice the user should then be asked if they
want to either add a Manager or a Developer)
4. Edit an Employee by id
5. Delete an Employee by id
6. View all Managers
7. View all Developers
8. View number of staff within a department
9. Payment (this should just ask for the number of hours worked in a week and
calculate and display pay based on rules stated above)
10. Show help
11. Exit Menu

With the Menu class, ensure you choose the correct selection statements and
appropriate methods for each action. As you will be working with inheritance you will
also need to know how to use ‘instanceof’ to distinguish between the different
Employees.
All Employees should be stored in a list. The same should be done for departments.
When the application starts up it should read all information from a file. When the
application is closing, it should write all data back out to file.

Task B
Create on-screen help to assist the users of the application. This should also be a
document that is a plain human readable file. This document should be readable
from the application through the console when the user requires information on how
to use the application as well as available offline as an ordinary text document.
Also create documentation for the support and maintenance of the application.

Task C

Use the agreed standard for naming, comments and code layout (see below). Also
validate all data that comes from inputs. Identify and implement opportunities for
error handling and reporting.

Task D
In this task you are required to test the program you have created and provide
documentation.
1. Prepare a test specification and test cases
2. Make effective use of the debugging tool available in the IDE
3. Select suitable test data and determine expected test results
4. Record actual test results to enable comparison with expected results
5. Analyse actual test results against expected results to identify discrepancies
6. Investigate test discrepancies to identify and rectify their causes

Coding Standard
All methods must be commented using Java doc standard. Any methods that may
need extra comments to allow other developers a better understanding of its function
can be added within the method.
Method names and variable names must all be written in camel case notation.
Package names will be written all lower case.
Class names and constructors, along with the project name will all be written in
Pascal Case.
Formatting will be essential. All code must be clean, tidy and readable. Opening
braces ( { ) will be placed at the end of the line and not on a new line.

draw.io
 */

/*TODO:
 * departments 
 * 	manager/developer move departments
 * draw.io diagrams
 */

package ie.eamonnsweeney;

import ie.eamonnsweeney.app.controllers.ApplicationController;
import ie.eamonnsweeney.app.helpers.Input;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class Main {
	
	/**
	 * The Application Entry Point
	 */
	public static void main(String[] args) {
		
		try {
			ApplicationController app = new ApplicationController();
			app.run();
		} catch (Exception e) {
			System.out.println("Unhandled Exception: " + e.getMessage());
			e.printStackTrace();
		} finally {
			Input.close();
		}
		
	}
	
}
