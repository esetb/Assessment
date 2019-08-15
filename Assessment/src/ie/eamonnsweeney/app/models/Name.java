/**
 * Name Class
 */
package ie.eamonnsweeney.app.models;

import java.io.Serializable;
import java.util.Objects;


// TODO: Auto-generated Javadoc
/**
 * The Class Name.
 *
 * @author Eamonn A. Sweeney
 */
public class Name implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5802807397429774898L;
	
	/** The title. */
	private String title;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/**
	 * Instantiates a new name.
	 *
	 * @param title the title
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public Name(String title, String firstName, String lastName) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 *
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Name [title=" + title 
				+ ", firstName=" + firstName 
				+ ", lastName=" + lastName 
				+ "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, title);
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
		if (!(obj instanceof Name))
			return false;
		Name other = (Name) obj;
		return Objects.equals(firstName, other.firstName) 
				&& Objects.equals(lastName, other.lastName)
				&& Objects.equals(title, other.title);
	}
	
}
