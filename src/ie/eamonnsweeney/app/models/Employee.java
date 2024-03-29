package ie.eamonnsweeney.app.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


/**
 * The Class Employee.
 *
 * @author Eamonn A. Sweeney
 */
public abstract class Employee implements Serializable, Payable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6721678774293692883L;
	
	/** The id num. */
	private int idNum;
	
	/** The name. */
	private Name name;
	
	/** The dept id num. */
	private int deptIdNum;
	
	/** The date started. */
	private LocalDate dateStarted;
	
	/** The phone num. */
	private String phoneNum;
	
	/**
	 * Instantiates a new employee.
	 *
	 * @param idNum the id num
	 * @param name the name
	 * @param deptIdNum the dept id num
	 * @param dateStarted the date started
	 * @param phoneNum the phone num
	 */
	protected Employee(int idNum, Name name, int deptIdNum, 
			LocalDate dateStarted, String phoneNum) {
		this.idNum = idNum;
		this.name = name;
		this.deptIdNum = deptIdNum;
		this.dateStarted = dateStarted;
		this.phoneNum = phoneNum;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public Name getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}
	
	/**
	 * Gets the dept id num.
	 *
	 * @return the deptIdNum
	 */
	public int getDeptIdNum() {
		return deptIdNum;
	}
	
	/**
	 * Sets the dept id num.
	 *
	 * @param deptIdNum the new dept id num
	 */
	public void setDeptIdNum(int deptIdNum) {
		this.deptIdNum = deptIdNum;
	}
	
	/**
	 * Gets the date started.
	 *
	 * @return the dateStarted
	 */
	public LocalDate getDateStarted() {
		return dateStarted;
	}
	
	/**
	 * Sets the date started.
	 *
	 * @param dateStarted the dateStarted to set
	 */
	public void setDateStarted(LocalDate dateStarted) {
		this.dateStarted = dateStarted;
	}
	
	/**
	 * Gets the phone num.
	 *
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	
	/**
	 * Sets the phone num.
	 *
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Employee: "  + name.getTitle() 
				+ " " + name.getFirstName()
				+ " " + name.getLastName()
				+ ", ID:" + idNum 
				+ ", Dept ID: " + deptIdNum 
				+ ", Date Started: " + dateStarted 
				+ ", Phone #: " + phoneNum 
				+ ".";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dateStarted, deptIdNum, idNum, name, phoneNum);
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
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dateStarted, other.dateStarted) 
				&& deptIdNum == other.deptIdNum 
				&& idNum == other.idNum
				&& Objects.equals(name, other.name) 
				&& Objects.equals(phoneNum, other.phoneNum);
	}

}
