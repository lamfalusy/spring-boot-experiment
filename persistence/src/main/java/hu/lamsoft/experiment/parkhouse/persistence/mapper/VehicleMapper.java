package hu.lamsoft.experiment.parkhouse.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hu.lamsoft.experiment.parkhouse.persistence.model.Vehicle;

@Mapper
public interface VehicleMapper {

	@Select("SELECT v.id, v.registration_number, v.weight_in_kg, v.number_of_wheels, c.id, c.firstname, c.lastname, c.email FROM vehicle v JOIN customer c ON v.owner_fk = c.id WHERE v.id = #{id}")
    public Vehicle findVehicleById(Long id);
	
	@Select("SELECT v.id, v.registration_number, v.weight_in_kg, v.number_of_wheels, c.id, c.firstname, c.lastname, c.email FROM vehicle v JOIN customer c ON v.owner_fk = c.id")
    public List<Vehicle> getAllVehicles();

	@Insert("INSERT into vehicle(registration_number,weight_in_kg,number_of_wheels,owner_fk) VALUES(#{registrationNumber}, #{weightInKg}, #{numberOfWheels}, #{owner.id})")
    public int insertVehicle(Vehicle vehicle);

	@Update("UPDATE vehicle SET registration_number=#{registrationNumber}, weight_in_kg=#{weightInKg}, number_of_wheels=#{numberOfWheels} WHERE id=#{id}")
    public int updateVehicle(Vehicle vehicle);
	
}
