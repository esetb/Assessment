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
class TestName {

	@Test
	void testGetTitle() {
		Name name = new Name("Mr.", "Eamonn", "Sweeney");
		assertTrue(name.getTitle().contentEquals("Mr."));
	}

}
