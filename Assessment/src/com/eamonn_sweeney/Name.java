package com.eamonn_sweeney;

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
		super();
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	public String toString() {
		return title + " " + firstName + " " + lastName;
	}
	
	// test for object value equality not object equality
	public boolean equals(Name name) {
		return this.title == name.getTitle() 
				&& this.firstName == name.getFirstName() 
				&& this.lastName == name.getLastName();
	}
	
}
