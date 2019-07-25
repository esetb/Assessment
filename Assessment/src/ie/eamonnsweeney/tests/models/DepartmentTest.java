/**
 * ie.eamonnsweeney.app.model.Department Class Tests
 */
package ie.eamonnsweeney.tests.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ie.eamonnsweeney.app.models.Department;

/**
 * @author Eamonn A. Sweeney
 *
 */
class DepartmentTest {

	private Department dept;
	private int idNum;
	private String name;
	private int numEmployees;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		idNum = 1;
		name = "DevOps";
		numEmployees = 8;
		dept = new Department(idNum, name, numEmployees); 
	}
	
	/**
	 * Test method for {@link ie.eamonnsweeney.Department#getIdNum()}.
	 */
	@Test
	void testGetIdNum() {
		assertEquals(idNum, dept.getIdNum());
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Department#getName()}.
	 */
	@Test
	void testGetName() {
		assertTrue(dept.getName().equals(name));
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Department#setName(java.lang.String)}.
	 */
	@Test
	void testSetName() {
		dept.setName("Development");
		assertTrue(dept.getName().equals("Development"));
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Department#getNumEmployees()}.
	 */
	@Test
	void testGetNumEmployees() {
		assertEquals(numEmployees, dept.getNumEmployees());
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Department#setNumEmployees(int)}.
	 */
	@Test
	void testSetNumEmployees() {
		dept.setNumEmployees(15);
		assertEquals(15, dept.getNumEmployees());
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Department#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		Department dept2 = new Department(idNum, name, numEmployees); 
		assertTrue(dept2.equals(dept));
	}

}