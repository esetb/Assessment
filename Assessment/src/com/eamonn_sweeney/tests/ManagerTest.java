/**
 * com.eamonn_sweeney.Manager Class Tests
 */
package com.eamonn_sweeney.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import com.eamonn_sweeney.Department;
import com.eamonn_sweeney.Manager;
import com.eamonn_sweeney.Name;

/**
 * @author STUDENT
 *
 */
class ManagerTest {

	private Manager man;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		Name name = new Name("Mr", "Eamonn", "Sweeney");
		Department dept = new Department(1, "DevOps", 8);
		LocalDate dateStarted = LocalDate.of(2018, 9, 14);
		man = new Manager(1, name, dept, dateStarted, "0873094169", 8, 60000.00, .10);
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Manager#getNumStaff()}.
	 */
	@Test
	void testGetNumStaff() {
		assertEquals(8, man.getNumStaff());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Manager#setNumStaff(int)}.
	 */
	@Test
	void testSetNumStaff() {
		man.setNumStaff(10);
		assertEquals(10, man.getNumStaff());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Manager#getSalary()}.
	 */
	@Test
	void testGetSalary() {
		assertEquals(60000.00, man.getSalary());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Manager#setSalary(double)}.
	 */
	@Test
	void testSetSalary() {
		man.setSalary(65000.00);
		assertEquals(65000.00, man.getSalary());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Manager#getBonus()}.
	 */
	@Test
	void testGetBonus() {
		assertEquals(.1, man.getBonus());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Manager#setBonus(double)}.
	 */
	@Test
	void testSetBonus() {
		man.setBonus(.15);
		assertEquals(.15, man.getBonus());
	}

}
