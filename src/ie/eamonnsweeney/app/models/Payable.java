package ie.eamonnsweeney.app.models;

/**
 * The Interface Payable.
 */
public interface Payable {
	
	/**
	 * Calulate pay.
	 *
	 * @param numHoursWorked the num hours worked
	 * @return the double
	 */
	double calulatePay(int numHoursWorked);
}
