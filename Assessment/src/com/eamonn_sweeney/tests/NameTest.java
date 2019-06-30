/**
 * 
 */
package com.eamonn_sweeney.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.eamonn_sweeney.Name;
import com.eamonn_sweeney.Name.Title;

/**
 * @author Eamonn
 *
 */
class NameTest {

	@Test
	void testGetTitle() {
		Name name = new Name(Title.MR, "Eamonn", "Sweeney");
		assertTrue(name.getTitle().contentEquals("Mr"));
	}
	
}
