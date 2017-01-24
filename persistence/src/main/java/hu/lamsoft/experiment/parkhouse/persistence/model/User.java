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
public class User extends BaseModel {
	
	private static final long serialVersionUID = 1L;

	private String userName;
	private String email;
	
	@Builder
	public User(Long id, String userName, String email) {
		super(id);
		this.userName = userName;
		this.email = email;
	}
	
}
