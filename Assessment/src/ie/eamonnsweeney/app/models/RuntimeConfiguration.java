/**
 * 
 */
package ie.eamonnsweeney.app.models;


/**
 * The Class RuntimeConfiguration.
 *
 * @author Eamonn A. Sweeney
 * 
 * Constant runtime values. 
 * If requirements change it allows the possibility of using atext based config 
 * file, eg, ini.
 */
public class RuntimeConfiguration {
	
	/** The max managers per department. */
	private final int MAX_MANAGERS_PER_DEPARTMENT = 2;
	
	/** The max employees per department. */
	private final int MAX_EMPLOYEES_PER_DEPARTMENT = 14;
	
	/**
	 * Gets the max managers per department.
	 *
	 * @return the max managers per department
	 */
	public int getMaxManagersPerDepartment() {
		return MAX_MANAGERS_PER_DEPARTMENT;
	}

	/**
	 * Gets the max employees per department.
	 *
	 * @return the max employees per department
	 */
	public int getMaxEmployeesPerDepartment() {
		return MAX_EMPLOYEES_PER_DEPARTMENT;
	}
	
}
