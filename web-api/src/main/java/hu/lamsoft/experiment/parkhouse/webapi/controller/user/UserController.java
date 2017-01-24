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
		return userService.findById(id);
	}
	
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.findAll();
	}
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public User createUser(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "email", required = true) String email) {
		User user = User.builder().userName(userName).email(email).build();
		userService.create(user);
		return user;
	}
	
	@RequestMapping(path = "/user", method = RequestMethod.PUT)
	public User updateUser(@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "email", required = false) String email) {
		User user = userService.findById(id);
		if(userName != null) {
			user.setUserName(userName);
		}
		if(email != null) {
			user.setEmail(email);
		}
		userService.update(user);
		return user;
	}
	
}
