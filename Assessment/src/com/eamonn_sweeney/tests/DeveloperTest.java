/**
 * 
 */
package com.eamonn_sweeney.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import com.eamonn_sweeney.Developer;
import com.eamonn_sweeney.Name;
import com.eamonn_sweeney.Name.Title;
import com.eamonn_sweeney.Department; 

/**
 * @author Eamonn
 *
 */
class DeveloperTest {

	private Developer developer;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		Name name = new Name(Title.MR, "Eamonn", "Sweeney");
		Department dept = new Department(1, "DevOps", 8);
		LocalDate dateStarted = LocalDate.of(2018, 9, 14);
		this.developer = new Developer(1, name, dept, dateStarted, "0873094169", 4000.00, 3);
	}

	@Test
	void testGetIdNum() {
		assertEquals(1, this.developer.getIdNum());
	}

}
