package ie.eamonnsweeney.app.models;

import java.time.LocalDate;
import java.util.Objects;


/**
 * The Class Developer.
 *
 * @author Eamonn A. Sweeney
 */
public class Developer extends Employee {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6343705531349944709L;
	
	/**
	 * The Enum Level.
	 */
	public enum Level {
		
		/** Level one. */
		ONE(1, 17.0),
		
		/** Level two. */
		TWO(2, 18.0),
		
		/** Level three. */
		THREE(3, 19.50);
		
		/** The level num. */
		private final int levelNum;
		
		/** The hourly rate. */
		private final double hourlyRate;
		
		/**
		 * Instantiates a new level.
		 *
		 * @param levelNum the level num
		 * @param hourlyRate the hourly rate
		 */
		private Level(int levelNum, double hourlyRate) {
			this.levelNum = levelNum;
			this.hourlyRate = hourlyRate;
		}
		
		/**
		 * To string.
		 *
		 * @return the string
		 */
		@Override
		public String toString() {
			return "" + levelNum;
		}
	}
	
	/** The level. */
	private Level level;
	
	/**
	 * Instantiates a new developer.
	 *
	 * @param idNum the id num
	 * @param name the name
	 * @param deptIdNum the dept id num
	 * @param dateStarted the date started
	 * @param phoneNum the phone num
	 * @param level the level
	 */
	public Developer(int idNum, Name name, int deptIdNum, LocalDate dateStarted, 
			String phoneNum, Level level) {
		super(idNum, name, deptIdNum, dateStarted, phoneNum);
		this.level = level;
		super.setMonthlyPay(level.hourlyRate * getNormalWorkHours() * 4);
	}
	
	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the level to set
	 */
	public void setLevel(Developer.Level level) {
		this.level = level;
	}

	/**
	 * Calculate pay.
	 *
	 * @param numHoursWorked the num hours worked
	 * @return the double
	 */
	public double calculatePay(int numHoursWorked) {
		int normalWorkHours = getNormalWorkHours();
		int normalHoursWorked = 0;
		int overtimeHoursWorked = 0;
		double weeklyPay = 0;
		
		if (numHoursWorked > normalWorkHours) {
			normalHoursWorked = normalWorkHours;
			overtimeHoursWorked = (numHoursWorked - normalWorkHours);
		} else {
			normalHoursWorked = numHoursWorked;
		}
		
		weeklyPay = normalHoursWorked * level.hourlyRate;
		weeklyPay += ((overtimeHoursWorked * level.hourlyRate) * 1.5);
		
		return weeklyPay;
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
				+ ", Department ID: " + getDeptIdNum()
				+ ", Date Started: " + getDateStarted()
				+ ", Phone: " + getPhoneNum() 
				+ ", Level: " + level.levelNum
				+ ", Hourly Rate: " + level.hourlyRate
				+ ".";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(level);
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
		if (obj == null)
			return false;
		if (!(obj instanceof Developer))
			return false;
		Developer other = (Developer) obj;
		return level == other.level;
	}
	
}
