/**
 * Manager Class extends Employee
 */
package com.eamonn_sweeney.app.model;

import java.time.LocalDate;
import java.util.Objects;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class Manager extends Employee {
	
	private static final long serialVersionUID = 4532872524230525657L;
	private int numStaff;
	private double salary;
	private double bonus;

	/**
	 * @param idNum
	 * @param name
	 * @param dept
	 * @param dateStarted
	 * @param phoneNum
	 * @param numStaff
	 * @param salary
	 * @param bonus
	 */
	public Manager(int idNum, Name name, int deptIdNum, LocalDate dateStarted, 
			String phoneNum, int numStaff, double salary, double bonus) {
		super(idNum, name, deptIdNum, dateStarted, phoneNum, (salary / 12));
		this.numStaff = numStaff;
		this.salary = salary;
		this.bonus = bonus;
	}

	/**
	 * @return the numStaff
	 */
	public int getNumStaff() {
		return numStaff;
	}

	/**
	 * @param numStaff the numStaff to set
	 */
	public void setNumStaff(int numStaff) {
		this.numStaff = numStaff;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
		this.monthlyPay = (salary / 12);
	}

	/**
	 * @return the bonus
	 */
	public double getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Manager [idNum=" + idNum
				+ ", name=" + name 
				+ ", dept=" + deptIdNum 
				+ ", dateStarted=" + dateStarted 
				+ ", phoneNum=" + phoneNum
				+ ", monthlyPay=" + monthlyPay 
				+ ", numStaff=" + numStaff 
				+ ", salary=" + salary 
				+ ", bonus=" + bonus 
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bonus, numStaff, salary);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Manager))
			return false;
		Manager other = (Manager) obj;
		return Double.doubleToLongBits(bonus) == Double.doubleToLongBits(other.bonus) 
				&& numStaff == other.numStaff
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	
}
