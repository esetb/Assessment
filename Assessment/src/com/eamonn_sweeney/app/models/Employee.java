/**
 * Abstract Employee Class
 */
package com.eamonn_sweeney.app.models;

import java.time.LocalDate;
import java.util.Objects;


/**
 * @author Eamonn A. Sweeney
 *
 */
public abstract class Employee {
	
	protected int idNum;
	protected Name name;
	protected Department dept;
	protected LocalDate dateStarted;
	protected String phoneNum;
	protected double monthlyPay;
	
	
	/**
	 * @param idNum
	 * @param name
	 * @param dept
	 * @param dateStarted
	 * @param phoneNum
	 * @param monthlyPay
	 */
	protected Employee(int idNum, Name name, Department dept, LocalDate dateStarted, 
			String phoneNum, double monthlyPay) {
		this.idNum = idNum;
		this.name = name;
		this.dept = dept;
		this.dateStarted = dateStarted;
		this.phoneNum = phoneNum;
		this.monthlyPay = monthlyPay;
	}

	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}
	
	/**
	 * @return the dept
	 */
	public Department getDept() {
		return dept;
	}
	
	/**
	 * @param dept the dept to set
	 */
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	/**
	 * @return the dateStarted
	 */
	public LocalDate getDateStarted() {
		return dateStarted;
	}
	
	/**
	 * @param dateStarted the dateStarted to set
	 */
	public void setDateStarted(LocalDate dateStarted) {
		this.dateStarted = dateStarted;
	}
	
	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	
	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	/**
	 * @return the monthlyPay
	 */
	public double getMonthlyPay() {
		return monthlyPay;
	}
	
	/**
	 * @param monthlyPay the monthlyPay to set
	 */
	public void setMonthlyPay(double monthlyPay) {
		this.monthlyPay = monthlyPay;
	}
	
	/**
	 * @return the idNum
	 */
	public int getIdNum() {
		return idNum;
	}

	/**
	 * @param idNum the idNum to set
	 */
	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}
	
	@Override
	public String toString() {
		return "Employee [idNum=" + idNum 
				+ ", name=" + name 
				+ ", dept=" + dept.getName() 
				+ ", dateStarted=" + dateStarted
				+ ", phoneNum=" + phoneNum 
				+ ", monthlyPay=" + monthlyPay 
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateStarted, dept, idNum, monthlyPay, name, phoneNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dateStarted, other.dateStarted) 
				&& Objects.equals(dept, other.dept)
				&& idNum == other.idNum
				&& Double.doubleToLongBits(monthlyPay) == Double.doubleToLongBits(other.monthlyPay)
				&& Objects.equals(name, other.name) 
				&& Objects.equals(phoneNum, other.phoneNum);
	}
	
}
