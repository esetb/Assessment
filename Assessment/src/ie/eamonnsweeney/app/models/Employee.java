/**
 * Abstract Employee Class
 */
package ie.eamonnsweeney.app.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


/**
 * @author Eamonn A. Sweeney
 *
 */
public abstract class Employee implements Serializable {
	
	protected static final long serialVersionUID = 6721678774293692883L;
	protected int idNum;
	protected Name name;
	protected int deptIdNum;
	protected LocalDate dateStarted;
	protected String phoneNum;
	protected double monthlyPay;
	
	/**
	 * @param idNum
	 * @param name
	 * @param dept
	 * @param dateStarted
	 * @param phoneNum
	 */
	protected Employee(int idNum, Name name, int deptIdNum, 
			LocalDate dateStarted, String phoneNum) {
		this.idNum = idNum;
		this.name = name;
		this.deptIdNum = deptIdNum;
		this.dateStarted = dateStarted;
		this.phoneNum = phoneNum;
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
	 * @return the deptIdNum
	 */
	public int getDeptIdNum() {
		return deptIdNum;
	}
	
	/**
	 * @param dept the deptIdNum to set
	 */
	public void setDeptIdNum(int deptIdNum) {
		this.deptIdNum = deptIdNum;
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

	@Override
	public String toString() {
		return "Employee [idNum=" + idNum 
				+ ", name=" + name 
				+ ", deptIdNum=" + deptIdNum 
				+ ", dateStarted=" + dateStarted 
				+ ", phoneNum=" + phoneNum 
				+ ", monthlyPay=" + monthlyPay 
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateStarted, deptIdNum, idNum, monthlyPay, name, phoneNum);
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
				&& deptIdNum == other.deptIdNum 
				&& idNum == other.idNum
				&& Double.doubleToLongBits(monthlyPay) == Double.doubleToLongBits(other.monthlyPay)
				&& Objects.equals(name, other.name) 
				&& Objects.equals(phoneNum, other.phoneNum);
	}
	
}
