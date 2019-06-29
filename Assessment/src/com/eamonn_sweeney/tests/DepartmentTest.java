package com.eamonn_sweeney.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.eamonn_sweeney.Department;

class DepartmentTest {

	@Test
	void testGetDeptId() {
		Department dept = new Department(1, "Legal", 3);
		assertEquals(1, dept.getDeptId());
	}

}
