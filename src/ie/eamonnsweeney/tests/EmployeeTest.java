package ie.eamonnsweeney.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Manager;
import ie.eamonnsweeney.app.models.Name;

class EmployeeTest {

	Employee employee;
	
	/**
	 * Sets the objects state for each test.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		employee = (Employee) new Manager(1, new Name("Mr", "Scrooge", "McDuck"), 1
				, LocalDate.of(2010, 1, 1), "555-123456", 0, 60000.0, .15);
	}

	/**
	 * Test get name.
	 */
	@Test
	void testGetName() {
		assertEquals(new Name("Mr", "Scrooge", "McDuck"), employee.getName());
	}

	/**
	 * Test set name.
	 */
	@Test
	void testSetName() {
		employee.setName(new Name("Mr", "Louie", "Duck"));
		assertEquals(new Name("Mr", "Louie", "Duck"), employee.getName());
	}

	/**
	 * Test get dept id num.
	 */
	@Test
	void testGetDeptIdNum() {
		assertEquals(1, employee.getDeptIdNum());
	}

	/**
	 * Test set dept id num.
	 */
	@Test
	void testSetDeptIdNum() {
		employee.setDeptIdNum(2);
		assertEquals(2, employee.getDeptIdNum());
	}

	/**
	 * Test get date started.
	 */
	@Test
	void testGetDateStarted() {
		assertEquals(LocalDate.of(2010,  1, 1), employee.getDateStarted());
	}

	/**
	 * Test set date started.
	 */
	@Test
	void testSetDateStarted() {
		employee.setDateStarted(LocalDate.of(2014, 12, 25));
		assertEquals(LocalDate.of(2014, 12, 25), employee.getDateStarted());
	}

	/**
	 * Test get phone num.
	 */
	@Test
	void testGetPhoneNum() {
		assertEquals("555-123456", employee.getPhoneNum());
	}

	/**
	 * Test set phone num.
	 */
	@Test
	void testSetPhoneNum() {
		employee.setPhoneNum("555-654321");
		assertEquals("555-654321", employee.getPhoneNum());
	}

	/**
	 * Test get id num.
	 */
	@Test
	void testGetIdNum() {
		assertEquals(1, employee.getIdNum());
	}

	@Test
	void testEqualsObject() {
		assertTrue(employee.equals((Employee) new Manager(1, new Name("Mr", "Scrooge", "McDuck"), 1
				, LocalDate.of(2010, 1, 1), "555-123456", 0, 60000.0, .15)));
	}

}
