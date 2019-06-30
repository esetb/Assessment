package com.eamonn_sweeney;

public class Name {
	public enum Title {
		MASTER("Master"), 	// Male usually under 18
		MR("Mr"),			// Male adult.
		MISS("Miss"),		// Female usually under 18, unmarried
		MS("Ms"),			// Female adult, marital status unknown or still using maiden name
		MRS("Mrs"),			// Female adult, married
		MX("Mx"),			// MX / M Gender neutral honorific for those who do not wish to specify 
		M("M");				// their gender or do not consider themselves male or female. 
		
		private final String titleStr;

	    /**
		 * @param titleStr
		 */
		private Title(String titleStr) {
			this.titleStr = titleStr;
		}

		@Override
	    public String toString() {
	        return titleStr;
	    }
	}
	private Title title;
	private String firstName;
	private String lastName;
	
	/**
	 * @param title
	 * @param firstName
	 * @param lastName
	 */
	public Name(Title title, String firstName, String lastName) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the title as a string
	 */
	public String getTitle() {
		return title.toString();
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(Title title) {
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
		return title.toString() + " " + firstName + " " + lastName;
	}
	
}
