package hu.lamsoft.experiment.parkhouse.webapi.controller.vehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.experiment.parkhouse.persistence.model.Customer;
import hu.lamsoft.experiment.parkhouse.persistence.model.Vehicle;
import hu.lamsoft.experiment.parkhouse.service.vehicle.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(path = "/vehicle", method = RequestMethod.GET)
	public List<Vehicle> getVehicles() {
		return vehicleService.findAll();
	}
	
	@RequestMapping(path = "/customer/{customerId}/vehicle", method = RequestMethod.POST)
	public Vehicle createVehicle(@PathVariable(value = "customerId", required = true) Long customerId,
			@RequestParam(value = "registrationNumber", required = true) String registrationNumber,
			@RequestParam(value = "weightInKg", required = false) Double weightInKg,
			@RequestParam(value = "numberOfWheels", required = false) Integer numberOfWheels) {
		Vehicle vehicle = Vehicle.builder().owner(new Customer(customerId)).registrationNumber(registrationNumber).weightInKg(weightInKg).numberOfWheels(numberOfWheels).build();
		vehicleService.create(vehicle);
		return vehicle;
	}
	
	
	
}
