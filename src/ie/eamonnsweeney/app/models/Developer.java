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
	
	/** The hourly rate. */
	private double hourlyRate;
	
	/** The normal work hours. */
	private final int NORMAL_WORK_HOURS = 35;
	
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
		this.hourlyRate = level.hourlyRate;
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
	 * Gets the hourly rate.
	 *
	 * @return the hourly rate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * Gets the normal work hours.
	 *
	 * @return the normal work hours
	 */
	protected int getNormalWorkHours() {
		return NORMAL_WORK_HOURS;
	}
	
	/**
	 * Calculate pay.
	 *
	 * @param numHoursWorked the num hours worked
	 * @return the double
	 */
	public double calculatePay(int numHoursWorked) {
		int normalHoursWorked = 0;
		int overtimeHoursWorked = 0;
		double weeklyPay = 0;
		
		if (numHoursWorked > NORMAL_WORK_HOURS) {
			normalHoursWorked = NORMAL_WORK_HOURS;
			overtimeHoursWorked = (numHoursWorked - NORMAL_WORK_HOURS);
		} else {
			normalHoursWorked = numHoursWorked;
		}
		
		weeklyPay = normalHoursWorked * hourlyRate;
		weeklyPay += ((overtimeHoursWorked * hourlyRate) * 1.5);
		
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
				+ ", Hourly Rate: " + hourlyRate
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
		result = prime * result + Objects.hash(hourlyRate, level);
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
		if (!(obj instanceof Developer))
			return false;
		Developer other = (Developer) obj;
		return Double.doubleToLongBits(hourlyRate) == Double.doubleToLongBits(other.hourlyRate) 
				&& level == other.level;
	}
	
}
