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
	 * Sets the up.
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

	/**
	 * Test get name.
	 */
	@Test
	void testGetName() {
		assertEquals(new Name("Mr", "Huey", "Duck"), developer.getName());
	}

	/**
	 * Test set name.
	 */
	@Test
	void testSetName() {
		developer.setName(new Name("Mr", "Louie", "Duck"));
		assertEquals(new Name("Mr", "Louie", "Duck"), developer.getName());
	}

	/**
	 * Test get dept id num.
	 */
	@Test
	void testGetDeptIdNum() {
		assertEquals(1, developer.getDeptIdNum());
	}

	/**
	 * Test set dept id num.
	 */
	@Test
	void testSetDeptIdNum() {
		developer.setDeptIdNum(2);
		assertEquals(2, developer.getDeptIdNum());
	}

	/**
	 * Test get date started.
	 */
	@Test
	void testGetDateStarted() {
		assertEquals(LocalDate.of(2010,  1, 1), developer.getDateStarted());
	}

	/**
	 * Test set date started.
	 */
	@Test
	void testSetDateStarted() {
		developer.setDateStarted(LocalDate.of(2014, 12, 25));
		assertEquals(LocalDate.of(2014, 12, 25), developer.getDateStarted());
	}

	/**
	 * Test get phone num.
	 */
	@Test
	void testGetPhoneNum() {
		assertEquals("555-123456", developer.getPhoneNum());
	}

	/**
	 * Test set phone num.
	 */
	@Test
	void testSetPhoneNum() {
		developer.setPhoneNum("555-654321");
		assertEquals("555-654321", developer.getPhoneNum());
	}

	/**
	 * Test get id num.
	 */
	@Test
	void testGetIdNum() {
		assertEquals(1, developer.getIdNum());
	}

}
