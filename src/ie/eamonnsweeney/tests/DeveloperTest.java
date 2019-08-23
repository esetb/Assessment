package ie.eamonnsweeney.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Name;


/**
 * The Class DeveloperTest.
 */
class DeveloperTest {

	/** The developer. */
	Developer developer;
	
	/**
	 * Sets the objects state for each test.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		developer = new Developer(1, new Name("Mr", "Huey", "Duck"), 1
				, LocalDate.of(2010, 1, 1), "555-123456", Developer.Level.ONE);
	}

	/**
	 * Test developer.
	 */
	@Test
	void testDeveloper() {
		assertEquals(developer, new Developer(1, new Name("Mr", "Huey", "Duck")
				, 1, LocalDate.of(2010, 1, 1), "555-123456", Developer.Level.ONE));
	}
	
	/**
	 * Test equals object.
	 */
	@Test
	void testEqualsObject() {
		assertTrue(developer.equals(new Developer(1, new Name("Mr", "Huey", "Duck")
				, 1, LocalDate.of(2010, 1, 1), "555-123456", Developer.Level.ONE)));
	}

	/**
	 * Test get level.
	 */
	@Test
	void testGetLevel() {
		assertEquals(Developer.Level.ONE, developer.getLevel());
	}

	/**
	 * Test set level.
	 */
	@Test
	void testSetLevel() {
		developer.setLevel(Developer.Level.TWO);
		assertEquals(Developer.Level.TWO, developer.getLevel());
	}

	/**
	 * Test get hourly rate.
	 */
	@Test 
	void testGetHourlyRate() {
		assertEquals(17.0, developer.getHourlyRate());
	}
	
	/**
	 * Test calculate pay.
	 */
	@Test
	void testCalculatePay() {
		int numHoursWorked = 31;
		double rate = developer.getHourlyRate();
		assertEquals((double) (rate * numHoursWorked), developer.calculatePay(numHoursWorked));
	}
	
}
