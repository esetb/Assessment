/**
 * Department Class
 */
package ie.eamonnsweeney.app.models;

import java.io.Serializable;
import java.util.Objects;


/**
 * The Class Department.
 *
 * @author Eamonn A. Sweeney
 */
public class Department implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1928764860131292735L;
	
	/** The id num. */
	private int idNum;
	
	/** The name. */
	private String name;
	
	/** The num employees. */
	private int numEmployees;

	/**
	 * Instantiates a new department.
	 *
	 * @param idNum the id num
	 * @param name the name
	 * @param numEmployees the num employees
	 */
	public Department(int idNum, String name, int numEmployees) {
		this.idNum = idNum;
		this.name = name;
		this.numEmployees = numEmployees;
	}
	
	/**
	 * Gets the id num.
	 *
	 * @return the idNum
	 */
	public int getIdNum() {
		return idNum;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the num employees.
	 *
	 * @return the numEmployees
	 */
	public int getNumEmployees() {
		return numEmployees;
	}

	/**
	 * Sets the num employees.
	 *
	 * @param numEmployees the numEmployees to set
	 */
	public void setNumEmployees(int numEmployees) {
		this.numEmployees = numEmployees;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "" 
				+ name 
				+ ", ID: " + idNum 
				+ ", Employees: " + numEmployees
				;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(idNum, name, numEmployees);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Department))
			return false;
		Department other = (Department) obj;
		return idNum == other.idNum 
				&& Objects.equals(name, other.name) 
				&& numEmployees == other.numEmployees;
	}
		
}
