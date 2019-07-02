/**
 * com.eamonn_sweeney.Department Class Tests
 */
package com.eamonn_sweeney.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.eamonn_sweeney.app.models.Department;

/**
 * @author Eamonn A. Sweeney
 *
 */
class DepartmentTest {

	private Department dept;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		dept = new Department(1, "Development", 10); 
	}
	
	/**
	 * Test method for {@link com.eamonn_sweeney.Department#getIdNum()}.
	 */
	@Test
	void testGetIdNum() {
		assertEquals(1, dept.getIdNum());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Department#setIdNum(int)}.
	 */
	@Test
	void testSetIdNum() { 
		dept.setIdNum(7);
		assertEquals(7, dept.getIdNum());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Department#getName()}.
	 */
	@Test
	void testGetName() {
		assertTrue(dept.getName().equals("Development"));
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Department#setName(java.lang.String)}.
	 */
	@Test
	void testSetName() {
		dept.setName("DevOps");
		assertTrue(dept.getName().equals("DevOps"));
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Department#getNumEmployees()}.
	 */
	@Test
	void testGetNumEmployees() {
		assertEquals(10, dept.getNumEmployees());
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
		Department dept2 = new Department(1, "Development", 10); 
		assertTrue(dept2.equals(dept));
	}

}
