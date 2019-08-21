package ie.eamonnsweeney.app.models;

import java.time.LocalDate;


// TODO: Auto-generated Javadoc
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
		 * Gets the hourly rate.
		 *
		 * @return the hourly rate
		 */
		public double getHourlyRate() {
			return hourlyRate;
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
		super.setMonthlyPay(level.getHourlyRate() * 35 * 4);
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
		return 0;
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
				+ ", Level: " + level
				+ ", Hourly Rate: " + level.getHourlyRate()
				+ ".";
	}
	
}
