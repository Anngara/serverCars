package telran.cars.controller.service;

import java.time.LocalDate;

public class ServiceDateDays {
	LocalDate currentDate;
	int days;
	public ServiceDateDays(LocalDate currentDate, int days) {
		this.currentDate = currentDate;
		this.days = days;
	}
	public LocalDate getCurrentDate() {
		return currentDate;
	}
	public int getDays() {
		return days;
	}
	
}
