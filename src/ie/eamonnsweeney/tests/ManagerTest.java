package ie.eamonnsweeney.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ie.eamonnsweeney.app.models.Manager;
import ie.eamonnsweeney.app.models.Name;

class ManagerTest {

	Manager manager;
	
	/**
	 * Sets the objects state for each test.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		manager = new Manager(1, new Name("Mr", "Scrooge", "McDuck"), 1
				, LocalDate.of(2010, 1, 1), "555-123456", 0, 60000.0, .15);
	}

	@Test
	void testManager() {
		assertEquals(manager, new Manager(1, new Name("Mr", "Scrooge", "McDuck"), 1
				, LocalDate.of(2010, 1, 1), "555-123456", 0, 60000.0, .15));
	}

	@Test
	void testGetNumStaff() {
		assertEquals(0, manager.getNumStaff());
	}

	@Test
	void testSetNumStaff() {
		manager.setNumStaff(42);
		assertEquals(42, manager.getNumStaff());
	}

	@Test
	void testGetSalary() {
		assertEquals(60000.0, manager.getSalary());
	}

	@Test
	void testSetSalary() {
		manager.setSalary(50000);
		assertEquals(50000.0, manager.getSalary());
	}

	@Test
	void testGetBonus() {
		assertEquals(.15, manager.getBonus());
	}

	@Test
	void testSetBonus() {
		manager.setBonus(.25);
		assertEquals(.25, manager.getBonus());
	}

	@Test
	void testGetMonthlyPay() {
		assertEquals((manager.getSalary() / 12), manager.getMonthlyPay());
	}

	@Test
	void testCalculatePay() {
		int numHoursWorked = 35;
		assertEquals(manager.getMonthlyPay(), manager.calculatePay(numHoursWorked));
	}

}
