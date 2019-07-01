/**
 * 
 */
package com.eamonn_sweeney.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.eamonn_sweeney.Name;

/**
 * @author Eamonn
 *
 */
class NameTest {
	
	private Name name = new Name("Mr", "Eamonn", "Sweeney");;
	
	@Test
	void testGetTitle() {
		assertTrue(name.getTitle().contentEquals("Mr"));
	}
	
	@Test
	void testGetFirstName() {
		assertTrue(name.getFirstName().contentEquals("Eamonn"));
	}	
	
	@Test
	void testGetLastName() {
		assertTrue(name.getLastName().contentEquals("Sweeney"));
	}		
	
	@Test
	void testSetTitle() {
		name.setTitle("Master");
		assertTrue(name.getTitle().contentEquals("Master"));
	}
	
	@Test
	void testSetFirstName() {
		name.setFirstName("Anthony");
		assertTrue(name.getFirstName().contentEquals("Anthony"));
	}
	
	@Test
	void testSetLastName() {
		name.setLastName("Allen");
		assertTrue(name.getLastName().contentEquals("Allen"));
	}
	
	@Test
	void testEquals() {
		Name name2 = name;
		assertTrue(name2.equals(name));
	}
}
