package com.eamonn_sweeney.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.eamonn_sweeney.Department;


class DepartmentTest {

	private Department dept = new Department(1, "Development", 10); 
	
	@Test
	void testGetIdNum() {
		assertEquals(1, dept.getIdNum());
	}

	@Test
	void testGetName() {
		assertTrue(dept.getName().equals("Development"));
	}
	
	@Test
	void testGetNumEmployees() {
		assertEquals(10, dept.getNumEmployees());
	}	
	
	@Test
	void testSetIdNum() {
		dept.setIdNum(7);
		assertEquals(7, dept.getIdNum());
	}

	@Test
	void testSetName() {
		dept.setName("DevOps");
		assertTrue(dept.getName().equals("DevOps"));
	}
	
	@Test
	void testSetNumEmployees() {
		dept.setNumEmployees(11);
		assertEquals(11, dept.getNumEmployees());
	}
	
	@Test
	void testEquals() {
		Department dept2 = new Department(1, "Development", 10);
		assertTrue(dept2.equals(dept));
	}
	
}
