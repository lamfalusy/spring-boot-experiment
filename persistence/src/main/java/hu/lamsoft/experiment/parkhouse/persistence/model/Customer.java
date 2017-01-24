package hu.lamsoft.experiment.parkhouse.persistence.model;

import java.util.LinkedList;
import java.util.List;

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
public class Customer extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String email;
	private List<Vehicle> vehicles = new LinkedList<>();
	
	@Builder
	public Customer(Long id, String firstName, String lastName, String email, List<Vehicle> vehicles) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.vehicles = vehicles;
	}

	public Customer(Long id) {
		super(id);
	}
	
}
