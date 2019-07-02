/**
 * Name Class
 */
package com.eamonn_sweeney.app.models;

import java.util.Objects;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class Name {
	private String title;
	private String firstName;
	private String lastName;
	
	/**
	 * @param title
	 * @param firstName
	 * @param lastName
	 */
	public Name(String title, String firstName, String lastName) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Name [title=" + title 
				+ ", firstName=" + firstName 
				+ ", lastName=" + lastName 
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, title);
	}

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
