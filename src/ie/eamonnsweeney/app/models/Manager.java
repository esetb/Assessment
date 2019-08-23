package ie.eamonnsweeney.app.models;

import java.time.LocalDate;
import java.util.Objects;


// TODO: Auto-generated Javadoc
/**
 * The Class Manager.
 *
 * @author Eamonn A. Sweeney
 */
public class Manager extends Employee {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4532872524230525657L;
	
	/** The num staff. */
	private int numStaff;
	
	/** The monthly salary. */
	private double monthlySalary;
	
	/** The bonus. */
	private double bonus;
	
	/**
	 * Instantiates a new manager.
	 *
	 * @param idNum the id num
	 * @param name the name
	 * @param deptIdNum the dept id num
	 * @param dateStarted the date started
	 * @param phoneNum the phone num
	 * @param numStaff the num staff
	 * @param monthlySalary the monthly salary
	 * @param bonus the bonus
	 */
	public Manager(int idNum, Name name, int deptIdNum, LocalDate dateStarted, 
			String phoneNum, int numStaff, double monthlySalary, double bonus) {
		super(idNum, name, deptIdNum, dateStarted, phoneNum);
		this.numStaff = numStaff;
		this.monthlySalary = monthlySalary;
		this.bonus = bonus;
	}

	/**
	 * Gets the num staff.
	 *
	 * @return the numStaff
	 */
	public int getNumStaff() {
		return numStaff;
	}

	/**
	 * Sets the num staff.
	 *
	 * @param numStaff the numStaff to set
	 */
	public void setNumStaff(int numStaff) {
		this.numStaff = numStaff;
	}

	/**
	 * Gets the salary.
	 *
	 * @return the salary
	 */
	public double getMonthlySalary() {
		return monthlySalary;
	}

	/**
	 * Sets the salary.
	 *
	 * @param monthlySalary the new monthly salary
	 */
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	/**
	 * Gets the bonus.
	 *
	 * @return the bonus
	 */
	public double getBonus() {
		return bonus;
	}

	/**
	 * Sets the bonus.
	 *
	 * @param bonus the bonus to set
	 */
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	/**
	 * Calculate pay.
	 *
	 * @param numHoursWorked the num hours worked
	 * @return the double
	 */
	public double calculatePay(int numHoursWorked) {
		double weeklyPay = (monthlySalary / 4);
		weeklyPay += (weeklyPay * bonus);
		return weeklyPay ;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "" 
				+ getName().getTitle() 
				+ " " + getName().getFirstName() 
				+ " " + getName().getLastName() 
				+ ", ID: " + getIdNum()
				+ ", Department: " + getDeptIdNum()
				+ ", Date Started: " + getDateStarted().toString()
				+ ", Phone: " + getPhoneNum()  
				+ ", Staff Managed: " + numStaff 
				+ ", Salary: " + String.format("%.2f", monthlySalary) 
				+ ", Bonus: " + String.format("%.2f%%", (bonus * 100))
				+ ".";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bonus, monthlySalary, numStaff);
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
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
				&& Double.doubleToLongBits(monthlySalary) == Double.doubleToLongBits(other.monthlySalary)
				&& numStaff == other.numStaff;
	}

}
