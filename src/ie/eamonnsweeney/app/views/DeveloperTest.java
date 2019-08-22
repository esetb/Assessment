package ie.eamonnsweeney.app.views;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ie.eamonnsweeney.app.models.Developer;
import ie.eamonnsweeney.app.models.Name;

class DeveloperTest {

	Developer developer;
	
	@BeforeEach
	void setUp() throws Exception {
		developer = new Developer(1, new Name("Mr", "Huey", "Duck"), 1
				, LocalDate.of(2010, 1, 1), "555-123456", Developer.Level.ONE);
	}

	@Test
	void testDeveloper() {
		assertEquals(developer, new Developer(1, new Name("Mr", "Huey", "Duck")
				, 1, LocalDate.of(2010, 1, 1), "555-123456", Developer.Level.ONE));
	}
	
	@Test
	void testEqualsObject() {
		assertTrue(developer.equals(new Developer(1, new Name("Mr", "Huey", "Duck")
				, 1, LocalDate.of(2010, 1, 1), "555-123456", Developer.Level.ONE)));
	}

	@Test
	void testGetLevel() {
		assertEquals(Developer.Level.ONE, developer.getLevel());
	}

	@Test
	void testSetLevel() {
		developer.setLevel(Developer.Level.TWO);
		assertEquals(Developer.Level.TWO, developer.getLevel());
	}

	@Test
	void testCalculatePay() {
		int numHoursWorked = 31;
		double rate = 17;
		assertEquals((double) (rate * numHoursWorked), developer.calculatePay(numHoursWorked));
	}

	@Test
	void testGetName() {
		assertEquals(new Name("Mr", "Huey", "Duck"), developer.getName());
	}

	@Test
	void testSetName() {
		developer.setName(new Name("Mr", "Louie", "Duck"));
		assertEquals(new Name("Mr", "Louie", "Duck"), developer.getName());
	}

	@Test
	void testGetDeptIdNum() {
		assertEquals(1, developer.getDeptIdNum());
	}

	@Test
	void testSetDeptIdNum() {
		developer.setDeptIdNum(2);
		assertEquals(2, developer.getDeptIdNum());
	}

	@Test
	void testGetDateStarted() {
		assertEquals(LocalDate.of(2010,  1, 1), developer.getDateStarted());
	}

	@Test
	void testSetDateStarted() {
		developer.setDateStarted(LocalDate.of(2014, 12, 25));
		assertEquals(LocalDate.of(2014, 12, 25), developer.getDateStarted());
	}

	@Test
	void testGetPhoneNum() {
		assertEquals("555-123456", developer.getPhoneNum());
	}

	@Test
	void testSetPhoneNum() {
		developer.setPhoneNum("555-654321");
		assertEquals("555-654321", developer.getPhoneNum());
	}

	@Test
	void testGetIdNum() {
		assertEquals(1, developer.getIdNum());
	}

}
