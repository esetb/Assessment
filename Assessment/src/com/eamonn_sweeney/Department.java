package com.eamonn_sweeney;

public class Department {
	private int deptId;
	private String deptName;
	private int numEmployees;
	
	/**
	 * @param deptId
	 * @param deptName
	 * @param numEmployees
	 */
	public Department(int deptId, String deptName, int numEmployees) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.numEmployees = numEmployees;
	}

	/**
	 * @return the deptId
	 */
	public int getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the numEmployees
	 */
	public int getNumEmployees() {
		return numEmployees;
	}

	/**
	 * @param numEmployees the numEmployees to set
	 */
	public void setNumEmployees(int numEmployees) {
		this.numEmployees = numEmployees;
	}
	
	
}
