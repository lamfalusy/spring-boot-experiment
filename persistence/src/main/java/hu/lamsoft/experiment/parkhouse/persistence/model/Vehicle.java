package hu.lamsoft.experiment.parkhouse.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Vehicle extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	private String registrationNumber;
	private Double weightInKg;
	private Integer numberOfWheels;
	private Customer owner;
	
	@Builder
	public Vehicle(Long id, String registrationNumber, Double weightInKg, Integer numberOfWheels, Customer owner) {
		super(id);
		this.registrationNumber = registrationNumber;
		this.weightInKg = weightInKg;
		this.numberOfWheels = numberOfWheels;
		this.owner = owner;
	}
	
}
