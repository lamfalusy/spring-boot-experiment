package hu.lamsoft.experiment.parkhouse.service.vehicle.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.lamsoft.experiment.parkhouse.persistence.mapper.VehicleMapper;
import hu.lamsoft.experiment.parkhouse.persistence.model.Vehicle;
import hu.lamsoft.experiment.parkhouse.service.vehicle.VehicleService;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleMapper vehicleMapper;
	
	@Override
	public Vehicle findById(Long id) {
		return vehicleMapper.findVehicleById(id);
	}

	@Override
	public List<Vehicle> findAll() {
		return vehicleMapper.getAllVehicles();
	}

	@Override
	public Vehicle create(Vehicle vehicle) {
		vehicleMapper.insertVehicle(vehicle);
		return vehicle;
	}

	@Override
	public Vehicle update(Vehicle vehicle) {
		vehicleMapper.updateVehicle(vehicle);
		return vehicle;
	}

}
