package hu.lamsoft.experiment.parkhouse.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hu.lamsoft.experiment.parkhouse.persistence.model.Event;

@Mapper
public interface EventMapper {

	@Select("SELECT * FROM event WHERE id = #{id}")
    public Event findEventById(Long id);
	
	@Select("SELECT * FROM event")
    public List<Event> getAllEvents();

	@Insert("INSERT into event(registration_number,time,type) VALUES(#{registrationNumber}, #{time}, #{type})")
    public int insertEvent(Event event);

	@Update("UPDATE event SET registration_number=#{registrationNumber}, time=#{time}, type=#{type} WHERE id=#{id}")
    public int updateUser(Event event);
	
}
