package com.eamonn_sweeney;

import java.time.LocalDate;

public class Holiday {
	private LocalDate startDate;
	private LocalDate endDate;
	private Employee emp;
	
	/**
	 * @param startDate
	 * @param endDate
	 * @param emp
	 */
	public Holiday(LocalDate startDate, LocalDate endDate, Employee emp) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.emp = emp;
	}
	
}
