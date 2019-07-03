/**
 * com.eamonn_sweeney.Developer Class Tests
 */
package com.eamonn_sweeney.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import com.eamonn_sweeney.app.models.Developer;
import com.eamonn_sweeney.app.models.Developer.Level;
import com.eamonn_sweeney.app.models.Name;
 

/**
 * @author Eamonn A. Sweeney
 *
 */
class DeveloperTest {

	private Developer dev;
	private Level level;
	private double hourlyRate;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		level = Level.ONE;
		hourlyRate = level.getHourlyRate();
		dev = new Developer(1, new Name("Mr", "Eamonn", "Sweeney"), 1, 
				LocalDate.of(2018, 9, 14), "0873904169", level);
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Developer#getLevel()}.
	 */
	@Test
	void testGetLevel() {
		assertEquals(level, dev.getLevel());
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
		assertEquals(hourlyRate, dev.getHourlyRate());
	}
	
}
