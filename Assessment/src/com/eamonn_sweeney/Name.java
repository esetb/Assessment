package com.eamonn_sweeney;

/*
 * Use an enumerator for title?
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
		return title + " " + firstName + " " + lastName;
	}
	
	// test for object value equality not object equality - does not override Object.equals()
	public boolean equals(Name name) {
		return this.title == name.getTitle() 
				&& this.firstName == name.getFirstName() 
				&& this.lastName == name.getLastName();
	}
	
}
