/**
 * Department Class
 */
package ie.eamonnsweeney.app.models;

import java.io.Serializable;
import java.util.Objects;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class Department implements Serializable {
	
	private static final long serialVersionUID = 1928764860131292735L;
	private int idNum;
	private String name;
	private int numEmployees;

	/**
	 * @param idNum
	 * @param name
	 * @param numEmployees
	 */
	public Department(int idNum, String name, int numEmployees) {
		this.idNum = idNum;
		this.name = name;
		this.numEmployees = numEmployees;
	}
	
	/**
	 * @return the idNum
	 */
	public int getIdNum() {
		return idNum;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the numEmployees
	 */
	public int getNumEmployees() {
		return numEmployees;
	}

	/**
	 * @param numEmployees the numEmployees to set
	 */
	public void setNumEmployees(int numEmployees) {
		this.numEmployees = numEmployees;
	}

	@Override
	public String toString() {
		return "Department: " + name 
				+ ", Dept ID: " + idNum 
				+ ", # Employees: " + numEmployees 
				+ ".";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idNum, name, numEmployees);
	}

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
