package hu.lamsoft.experiment.parkhouse.persistence.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(callSuper = true)
public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
}
