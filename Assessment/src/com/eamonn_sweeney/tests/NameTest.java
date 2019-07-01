package com.eamonn_sweeney.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.eamonn_sweeney.Name;


class NameTest {
	
	private Name name = new Name("Mr", "Eamonn", "Sweeney");
	
	@Test
	void testGetTitle() {
		assertTrue(name.getTitle().equals("Mr"));
	}
	
	@Test
	void testGetFirstName() {
		assertTrue(name.getFirstName().equals("Eamonn"));
	}	
	
	@Test
	void testGetLastName() {
		assertTrue(name.getLastName().equals("Sweeney"));
	}		
	
	@Test
	void testSetTitle() {
		name.setTitle("Master");
		assertTrue(name.getTitle().equals("Master"));
	}
	
	@Test
	void testSetFirstName() {
		name.setFirstName("Anthony");
		assertTrue(name.getFirstName().equals("Anthony"));
	}
	
	@Test
	void testSetLastName() {
		name.setLastName("Allen");
		assertTrue(name.getLastName().equals("Allen"));
	}
	
	@Test
	void testEquals() {
		Name name2 = new Name("Mr", "Eamonn", "Sweeney");
		assertTrue(name2.equals(name));
	}
	
}
