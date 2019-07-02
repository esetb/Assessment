/**
 * com.eamonn_sweeney.Developer Class Tests
 */
package com.eamonn_sweeney.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import com.eamonn_sweeney.Department;
import com.eamonn_sweeney.Developer;
import com.eamonn_sweeney.Developer.Level;
import com.eamonn_sweeney.Name;
 

/**
 * @author Eamonn A. Sweeney
 *
 */
class DeveloperTest {

	private Developer dev;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		Name name = new Name("Mr", "Eamonn", "Sweeney");
		Department dept = new Department(1, "DevOps", 8);
		LocalDate dateStarted = LocalDate.of(2018, 9, 14);
		dev = new Developer(1, name, dept, dateStarted, "0873904169", 4000.00);
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Developer#getLevel()}.
	 */
	@Test
	void testGetLevel() {
		assertEquals(Level.ONE, dev.getLevel());
	}
	
	/**
	 * Test method for {@link com.eamonn_sweeney.Developer#setLevel(com.eamonn_sweeney.Developer.Level)}.
	 */
	@Test
	void testSetLevel() {
		dev.setLevel(Level.TWO);
		assertEquals(Level.TWO, dev.getLevel());
	}
	
	/**
	 * Test method for {@link com.eamonn_sweeney.Developer#getHourlyRate()}.
	 */
	@Test
	void testGetHourlyRate() {
		assertEquals(17.0, dev.getHourlyRate());
	}
	
}
