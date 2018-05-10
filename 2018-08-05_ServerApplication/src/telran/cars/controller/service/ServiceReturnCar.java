package telran.cars.controller.service;

import java.time.LocalDate;

public class ServiceReturnCar {
	String carNumber;
	long licenseId;
	LocalDate returnDate;
	int gasTankPercent;
	int damages;
	public ServiceReturnCar(String carNumber, long licenseId, LocalDate returnDate, int gasTankPercent, int damages) {
		this.carNumber = carNumber;
		this.licenseId = licenseId;
		this.returnDate = returnDate;
		this.gasTankPercent = gasTankPercent;
		this.damages = damages;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public long getLicenseId() {
		return licenseId;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public int getGasTankPercent() {
		return gasTankPercent;
	}
	public int getDamages() {
		return damages;
	}
}
