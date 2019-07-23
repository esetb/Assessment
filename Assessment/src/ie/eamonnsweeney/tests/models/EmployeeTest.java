/**
 * ie.eamonnsweeney.app.model.Employee Class Tests
 */
package ie.eamonnsweeney.tests.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import ie.eamonnsweeney.app.models.Employee;
import ie.eamonnsweeney.app.models.Name;
import ie.eamonnsweeney.app.models.Developer;


/**
 * @author Eamonn A. Sweeney
 *
 */
class EmployeeTest {

	private Employee emp;
	private int idNum;
	private Name name;
	private int deptIdNum;
	private LocalDate dateStarted;
	private String phoneNum;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		idNum = 1;
		name = new Name("Mr", "Eamonn", "Sweeney");
		deptIdNum = 0;
		dateStarted = LocalDate.of(2018, 9, 14);
		phoneNum = "0873904169";
		emp = new Developer(idNum, name, deptIdNum, dateStarted, phoneNum, null);
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Employee#getName()}.
	 */
	@Test
	void testGetName() {
		assertEquals(name, emp.getName());
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Employee#setName(ie.eamonnsweeney.Name)}.
	 */
	@Test
	void testSetName() {
		Name newName = new Name("Mr", "Mickey", "Mouse");
		emp.setName(newName);
		assertEquals(newName, emp.getName());
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Employee#getDeptIdNum()}.
	 */
	@Test
	void testGetDeptIdNum() {
		assertEquals(deptIdNum, emp.getDeptIdNum());
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Employee#setDeptIdNum(int)}.
	 */
	@Test
	void testSetDeptIdNum() {
		emp.setDeptIdNum(7);
		assertEquals(7, emp.getDeptIdNum());
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Employee#getDateStarted()}.
	 */
	@Test
	void testGetDateStarted() {
		assertEquals(dateStarted, emp.getDateStarted());
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Employee#setDateStarted(java.time.LocalDate)}.
	 */
	@Test
	void testSetDateStarted() {
		LocalDate newDateStarted = LocalDate.of(2019, 7, 1);
		emp.setDateStarted(newDateStarted);
		assertEquals(newDateStarted, emp.getDateStarted());	
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Employee#getPhoneNum()}.
	 */
	@Test
	void testGetPhoneNum() {
		assertTrue(emp.getPhoneNum().equals("0873904169"));
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Employee#setPhoneNum(java.lang.String)}.
	 */
	@Test
	void testSetPhoneNum() {
		emp.setPhoneNum("0749561900");
		assertTrue(emp.getPhoneNum().equals("0749561900"));
	}

	/**
	 * Test method for {@link ie.eamonnsweeney.Employee#getIdNum()}.
	 */
	@Test
	void testGetIdNum() {
		assertEquals(idNum, emp.getIdNum());
	}
	
	/**
	 * Test method for {@link ie.eamonnsweeney.Employee#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		Employee emp2 = new Developer(idNum, name, deptIdNum, dateStarted, 
				phoneNum, Developer.Level.ONE);;
		assertTrue(emp2.equals(emp));
	}

}
