/**
 * com.eamonn_sweeney.app.model.Department Class Tests
 */
package com.eamonn_sweeney.tests.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.eamonn_sweeney.app.model.Department;

/**
 * @author Eamonn A. Sweeney
 *
 */
class DepartmentTest {

	private Department dept;
	private int idNum;
	private String name;
	private int numEmployees;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		idNum = 1;
		name = "DevOps";
		numEmployees = 8;
		dept = new Department(idNum, name, numEmployees); 
	}
	
	/**
	 * Test method for {@link com.eamonn_sweeney.Department#getIdNum()}.
	 */
	@Test
	void testGetIdNum() {
		assertEquals(idNum, dept.getIdNum());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Department#getName()}.
	 */
	@Test
	void testGetName() {
		assertTrue(dept.getName().equals(name));
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Department#setName(java.lang.String)}.
	 */
	@Test
	void testSetName() {
		dept.setName("Development");
		assertTrue(dept.getName().equals("Development"));
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Department#getNumEmployees()}.
	 */
	@Test
	void testGetNumEmployees() {
		assertEquals(numEmployees, dept.getNumEmployees());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Department#setNumEmployees(int)}.
	 */
	@Test
	void testSetNumEmployees() {
		dept.setNumEmployees(15);
		assertEquals(15, dept.getNumEmployees());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Department#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		Department dept2 = new Department(idNum, name, numEmployees); 
		assertTrue(dept2.equals(dept));
	}

}
