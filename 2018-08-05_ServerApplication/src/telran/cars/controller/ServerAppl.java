package telran.cars.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import telran.cars.model.*;
import telran.cars.controller.service.*;
import telran.cars.dto.*;

@SpringBootApplication
@RestController
public class ServerAppl {
	IRentCompany company = RentCompanyEmbedded.restoreFromFile("cars.data");

	@PutMapping(value = CarsApiConstants.SAVE)
	void save() {
		company.save();
	}

	@PostMapping(value = CarsApiConstants.ADD_CAR_MODEL)
	CarsReturnCode addModel(@RequestBody Model model) {
		return company.addModel(model);
	}
	
	@PostMapping(value = CarsApiConstants.ADD_CAR)
	CarsReturnCode addCar(@RequestBody Car car) {
		return company.addCar(car);
	}

	@PostMapping(value = CarsApiConstants.ADD_DRIVER)
	CarsReturnCode addDriver(@RequestBody Driver driver) {
		return company.addDriver(driver);
	}

	@GetMapping(value = CarsApiConstants.GET_MODEL)
	Model getCarModel(@RequestBody String modelName) {
		return company.getModel(modelName);
	}

	@GetMapping(value = CarsApiConstants.GET_CAR)
	Car getCar(@RequestBody String carNumber) {
		return company.getCar(carNumber);
	}

	@GetMapping(value = CarsApiConstants.GET_DRIVER)
	Driver getDriver(@RequestBody long licenseId) {
		return company.getDriver(licenseId);
	}

	@PostMapping(value = CarsApiConstants.RENT_CAR)
	CarsReturnCode rentCar(@RequestBody ServiceRentCar src) {
		return company.rentCar(src.getCarNumber(), src.getLicenseId(), src.getRentDate(), src.getRentDays());
	}

	@PostMapping(value = CarsApiConstants.RETURN_CAR)
	CarsReturnCode returnCar(@RequestBody ServiceReturnCar src) {
		return company.returnCar(src.getCarNumber(), src.getLicenseId(), src.getReturnDate(), src.getGasTankPercent(),
				src.getDamages());
	}

	@GetMapping(value = CarsApiConstants.REMOVE_CAR)
	CarsReturnCode removeCar(@RequestBody String carNumber) {
		return company.removeCar(carNumber);
	}

	@PostMapping(value = CarsApiConstants.CLEAR_CARS)
	List<Car> clear(@RequestBody ServiceDateDays sdd) {
		return company.clear(sdd.getCurrentDate(), sdd.getDays());
	}

	@GetMapping (value = CarsApiConstants.GET_CAR_DRIVERS)
	List<Driver> getCarDrivers(@RequestBody String carNumber) {
		return company.getCarDrivers(carNumber);
	}

	@GetMapping(value = CarsApiConstants.GET_DRIVER_CARS)
	List<Car> getDriverCars(@RequestBody long licenseId) {
		return company.getDriverCars(licenseId);
	}

	@RequestMapping(value = CarsApiConstants.GET_ALL_CARS)
	List <Car> getAllCars() {
		return company.getAllCars().collect(Collectors.toList());
	}
	
	@GetMapping(value = CarsApiConstants.GET_ALL_DRIVERS)
	List<Driver> getAllDrivers() {
		return company.getAllDrivers().collect(Collectors.toList());
	}

	@GetMapping(value = CarsApiConstants.GET_ALL_RECORDS)
	List<RentRecord> getAllRecords() {
		return company.getAllRecords().collect(Collectors.toList());
	}
	
	@GetMapping(value = CarsApiConstants.GET_ALL_MODELS)
	List <String> getAllModels() {
		return company.getAllModels();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ServerAppl.class, args);

	}

}
