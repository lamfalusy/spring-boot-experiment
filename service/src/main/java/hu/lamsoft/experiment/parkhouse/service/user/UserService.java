package hu.lamsoft.experiment.parkhouse.service.user;

import java.util.List;

import hu.lamsoft.experiment.parkhouse.persistence.model.User;

public interface UserService {

	User getUser(Long id);
	
	List<User> getUsers();
	
	User createUser(User user);
	
	User updateUser(User user);
	
}
