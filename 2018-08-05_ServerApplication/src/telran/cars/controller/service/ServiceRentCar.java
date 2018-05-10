package telran.cars.controller.service;

import java.time.LocalDate;

public class ServiceRentCar {
	String carNumber;
	long licenseId;
	LocalDate rentDate;
	int rentDays;
	public ServiceRentCar(String carNumber, long licenseId, LocalDate rentDate, int rentDays) {
		this.carNumber = carNumber;
		this.licenseId = licenseId;
		this.rentDate = rentDate;
		this.rentDays = rentDays;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public long getLicenseId() {
		return licenseId;
	}
	public LocalDate getRentDate() {
		return rentDate;
	}
	public int getRentDays() {
		return rentDays;
	}

	
}
