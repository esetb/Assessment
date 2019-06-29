package com.eamonn_sweeney;

public class Department {
	private int deptID;
	private String deptName;
	private int numEmployees;
	
	/**
	 * @param deptID
	 * @param deptName
	 * @param numEmployees
	 */
	public Department(int deptID, String deptName, int numEmployees) {
		this.deptID = deptID;
		this.deptName = deptName;
		this.numEmployees = numEmployees;
	}
	
	/**
	 * @return the deptID
	 */
	public int getDeptID() {
		return deptID;
	}
	
	/**
	 * @param deptID the deptID to set
	 */
	public void setDeptID(int deptID) {
		this.deptID = deptID;
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
