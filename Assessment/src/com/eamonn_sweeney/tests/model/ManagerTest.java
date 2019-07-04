/**
 * com.eamonn_sweeney.Manager Class Tests
 */
package com.eamonn_sweeney.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import com.eamonn_sweeney.app.model.Manager;
import com.eamonn_sweeney.app.model.Name;


/**
 * @author Eamonn A. Sweeney
 *
 */
class ManagerTest {

	private Manager man;
	private int numStaff;
	private double salary;
	private double bonus;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		numStaff = 8;
		salary = 60000.00;
		bonus = .10;
		man = new Manager(1, new Name("Mr", "Eamonn", "Sweeney"), 1, 
				LocalDate.of(2018, 9, 14), "0873094169", numStaff, salary, bonus);
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Manager#getNumStaff()}.
	 */
	@Test
	void testGetNumStaff() {
		assertEquals(numStaff, man.getNumStaff());
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
		assertEquals(salary, man.getSalary());
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
		assertEquals(bonus, man.getBonus());
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
