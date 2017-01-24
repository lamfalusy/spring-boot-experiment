package hu.lamsoft.experiment.parkhouse.persistence.model;

import java.util.Date;

import hu.lamsoft.experiment.parkhouse.persistence.model.enums.EventType;
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
public class Event extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	private String registrationNumber;
	private Date time;
	private EventType type;
	
	@Builder
	public Event(Long id, String registrationNumber, Date time, EventType type) {
		super(id);
		this.registrationNumber = registrationNumber;
		this.time = time;
		this.type = type;
	}
	
}
