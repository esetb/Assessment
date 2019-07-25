/**
 * ie.eamonnsweeney.app.model.Manager Class Tests
 */
package ie.eamonnsweeney.tests.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ie.eamonnsweeney.app.models.Manager;


/**
 * @author Eamonn A. Sweeney
 *
 */
class ManagerTest {

	private Manager man;
	private int numStaff;
	private double salary;
	private double bonus;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		numStaff = 8;
		salary = 60000.00;
		bonus = .10;
		man = new Manager(0, null, 0, null, null, numStaff, salary, bonus);
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Manager#getNumStaff()}.
	 */
	@Test
	void testGetNumStaff() {
		assertEquals(numStaff, man.getNumStaff());
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Manager#setNumStaff(int)}.
	 */
	@Test
	void testSetNumStaff() {
		man.setNumStaff(10);
		assertEquals(10, man.getNumStaff());
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Manager#getSalary()}.
	 */
	@Test
	void testGetSalary() {
		assertEquals(salary, man.getSalary());
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Manager#setSalary(double)}.
	 */
	@Test
	void testSetSalary() {
		man.setSalary(65000.00);
		assertEquals(65000.00, man.getSalary());
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Manager#getBonus()}.
	 */
	@Test
	void testGetBonus() {
		assertEquals(bonus, man.getBonus());
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Manager#setBonus(double)}.
	 */
	@Test
	void testSetBonus() {
		man.setBonus(.15);
		assertEquals(.15, man.getBonus());
	}

}