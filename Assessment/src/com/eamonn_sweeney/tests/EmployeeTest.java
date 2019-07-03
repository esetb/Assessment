/**
 * com.eamonn_sweeney.Employee Class Tests
 */
package com.eamonn_sweeney.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import com.eamonn_sweeney.app.models.Employee;
import com.eamonn_sweeney.app.models.Name;
import com.eamonn_sweeney.app.models.Department;
import com.eamonn_sweeney.app.models.Developer;


/**
 * @author Eamonn A. Sweeney
 *
 */
class EmployeeTest {

	private Employee emp;
	private Name name;
	private Department dept;
	private LocalDate dateStarted;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		name = new Name("Mr", "Eamonn", "Sweeney");
		dept = new Department(1, "Development", 8);
		dateStarted = LocalDate.of(2018, 9, 14);
		emp = new Developer(name, dept, dateStarted, "0873904169", 4000.00);
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Employee#getName()}.
	 */
	@Test
	void testGetName() {
		assertEquals(name, emp.getName());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Employee#setName(com.eamonn_sweeney.Name)}.
	 */
	@Test
	void testSetName() {
		Name newName = new Name("Mr", "Mickey", "Mouse");
		emp.setName(newName);
		assertEquals(newName, emp.getName());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Employee#getDept()}.
	 */
	@Test
	void testGetDept() {
		assertEquals(dept, emp.getDept());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Employee#setDept(com.eamonn_sweeney.Department)}.
	 */
	@Test
	void testSetDept() {
		Department newDept = new Department(2, "DevOps", 8);
		emp.setDept(newDept);
		assertEquals(newDept, emp.getDept());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Employee#getDateStarted()}.
	 */
	@Test
	void testGetDateStarted() {
		assertEquals(dateStarted, emp.getDateStarted());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Employee#setDateStarted(java.time.LocalDate)}.
	 */
	@Test
	void testSetDateStarted() {
		LocalDate newDateStarted = LocalDate.of(2019, 7, 1);
		emp.setDateStarted(newDateStarted);
		assertEquals(newDateStarted, emp.getDateStarted());	
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Employee#getPhoneNum()}.
	 */
	@Test
	void testGetPhoneNum() {
		assertTrue(emp.getPhoneNum().equals("0873904169"));
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Employee#setPhoneNum(java.lang.String)}.
	 */
	@Test
	void testSetPhoneNum() {
		emp.setPhoneNum("0749561900");
		assertTrue(emp.getPhoneNum().equals("0749561900"));
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Employee#getMonthlyPay()}.
	 */
	@Test
	void testGetMonthlyPay() {
		assertEquals(4000.00, emp.getMonthlyPay());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Employee#setMonthlyPay(double)}.
	 */
	@Test
	void testSetMonthlyPay() {
		emp.setMonthlyPay(6000.00);
		assertEquals(6000.00, emp.getMonthlyPay());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Employee#getIdNum()}.
	 */
	@Test
	void testGetIdNum() {
		assertEquals(1, emp.getIdNum());
	}
	
	/**
	 * Test method for {@link com.eamonn_sweeney.Employee#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		Employee emp2 = new Developer(name, dept, dateStarted, "0873094169", 4000.00);
		assertTrue(emp2.equals(emp));
	}

}
