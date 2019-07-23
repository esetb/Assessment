/**
 * com.eamonn_sweeney.app.model.Employee Class Tests
 */
package com.eamonn_sweeney.tests.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import com.eamonn_sweeney.app.model.Employee;
import com.eamonn_sweeney.app.model.Name;
import com.eamonn_sweeney.app.model.Developer;


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
	 * Test method for {@link com.eamonn_sweeney.Employee#getDeptIdNum()}.
	 */
	@Test
	void testGetDeptIdNum() {
		assertEquals(deptIdNum, emp.getDeptIdNum());
	}

	/**
	 * Test method for {@link com.eamonn_sweeney.Employee#setDeptIdNum(int)}.
	 */
	@Test
	void testSetDeptIdNum() {
		emp.setDeptIdNum(7);
		assertEquals(7, emp.getDeptIdNum());
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
		Developer dev = (Developer) emp;
		assertEquals((dev.getHourlyRate() * 35 * 4), emp.getMonthlyPay());
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
		assertEquals(idNum, emp.getIdNum());
	}
	
	/**
	 * Test method for {@link com.eamonn_sweeney.Employee#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		Employee emp2 = new Developer(idNum, name, deptIdNum, dateStarted, phoneNum);;
		assertTrue(emp2.equals(emp));
	}

}
