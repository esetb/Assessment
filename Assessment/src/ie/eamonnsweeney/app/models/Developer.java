/**
 * Developer Class extends Employee
 */
package ie.eamonnsweeney.app.models;

import java.time.LocalDate;
import java.util.Objects;


/**
 * @author Eamonn A. Sweeney
 * 
 */
public class Developer extends Employee {

	private static final long serialVersionUID = 6343705531349944709L;
	public enum Level {
		ONE(1, 17.0),
		TWO(2, 18.0),
		THREE(3, 19.50);
		
		private final int levelNum;
		private final double hourlyRate;
		
		/**
		 * 
		 */
		private Level(int levelNum, double hourlyRate) {
			this.levelNum = levelNum;
			this.hourlyRate = hourlyRate;
		}
		
		/**
		 * 
		 */
		public double getHourlyRate() {
			return hourlyRate;
		}
		
		@Override
		public String toString() {
			return "" + levelNum;
		}
	}
	private Level level;
	
	/**
	 * @param name
	 * @param deptIdNum
	 * @param dateStarted
	 * @param phoneNum
	 * @param level
	 */
	public Developer(int idNum, Name name, int deptIdNum, LocalDate dateStarted, 
			String phoneNum, Level level) {
		super(idNum, name, deptIdNum, dateStarted, phoneNum);
		this.level = level;
		this.monthlyPay = (level.getHourlyRate() * 35 * 4);
	}
	
	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Developer.Level level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "" 
				+ name.getTitle() 
				+ " " + name.getFirstName() 
				+ " " + name.getLastName() 
				+ ", ID: " + idNum 
				+ ", Department: " + deptIdNum 
				+ ", Date Started: " + dateStarted 
				+ ", Phone: " + phoneNum  
				+ ", Level: " + level
				+ ", Hourly Rate: " + level.getHourlyRate()
				+ ".";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(level);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Developer))
			return false;
		Developer other = (Developer) obj;
		return level == other.level;
	}
	
}
