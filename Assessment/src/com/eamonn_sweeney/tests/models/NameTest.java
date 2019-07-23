/**
 * com.eamonn_sweeney.app.model.Name Class Tests
 */
package com.eamonn_sweeney.tests.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.eamonn_sweeney.app.models.Name;


/**
 * @author Eamonn A. Sweeney
 *
 */
class NameTest {

	private Name name;
	private String title;
	private String firstName;
	private String lastName;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		title = "Mr";
		firstName = "Eamonn";
		lastName = "Sweeney";
		name = new Name(title, firstName, lastName);
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Name#getTitle()}.
	 */
	@Test
	void testGetTitle() {
		assertTrue(name.getTitle().equals(title));
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Name#setTitle(java.lang.String)}.
	 */
	@Test
	void testSetTitle() {
		name.setTitle("Master");
		assertTrue(name.getTitle().equals("Master"));
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Name#getFirstName()}.
	 */
	@Test
	void testGetFirstName() {
		assertTrue(name.getFirstName().equals(firstName));
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Name#setFirstName(java.lang.String)}.
	 */
	@Test
	void testSetFirstName() {
		name.setFirstName("Anthony");
		assertTrue(name.getFirstName().equals("Anthony"));
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Name#getLastName()}.
	 */
	@Test
	void testGetLastName() {
		assertTrue(name.getLastName().equals(lastName));
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Name#setLastName(java.lang.String)}.
	 */
	@Test
	void testSetLastName() {
		name.setLastName("Allen");
		assertTrue(name.getLastName().equals("Allen"));
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Name#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		Name name2 = new Name(title, firstName, lastName);
		assertTrue(name2.equals(name));
	}

}
