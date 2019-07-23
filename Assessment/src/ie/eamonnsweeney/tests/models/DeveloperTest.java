/**
 * ie.eamonnsweeney.app.model.Developer Class Tests
 */
package ie.eamonnsweeney.tests.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Name;
 

/**
 * @author Eamonn A. Sweeney
 *
 */
class DeveloperTest {

	private Developer dev;
	private Developer.Level level;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.level = Developer.Level.ONE;
		this.dev = new Developer(1, new Name("Mr", "Eamonn", "Sweeney"), 1, 
				LocalDate.of(2018, 9, 14), "0873904169", Developer.Level.ONE);
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Developer#getLevel()}.
	 */
	@Test
	void testGetLevel() {
		assertEquals(level, dev.getLevel());
	}
	
	/**
	 * Test method for {@link ie.eamonnsweeney.Developer#setLevel(ie.eamonnsweeney.Developer.Level)}.
	 */
	@Test
	void testSetLevel() {
		dev.setLevel(Developer.Level.TWO);
		assertEquals(Developer.Level.TWO, dev.getLevel());
	}
	
}
