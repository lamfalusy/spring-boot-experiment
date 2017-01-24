package hu.lamsoft.experiment.parkhouse.webapi.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.experiment.parkhouse.persistence.model.User;
import hu.lamsoft.experiment.parkhouse.service.user.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "/user", method = RequestMethod.GET)
	public User getUser(@RequestParam(value = "id", required = true) Long id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public User createUser(@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = true) String lastName,
			@RequestParam(value = "email", required = true) String email) {
		User user = new User(null, firstName, lastName, email);
		userService.createUser(user);
		return user;
	}
	
	@RequestMapping(path = "/user", method = RequestMethod.PUT)
	public User updateUser(@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "email", required = false) String email) {
		User user = userService.getUser(id);
		if(firstName != null) {
			user.setFirstName(firstName);
		}
		if(lastName != null) {
			user.setLastName(lastName);
		}
		if(email != null) {
			user.setEmail(email);
		}
		userService.updateUser(user);
		return user;
	}
	
}
