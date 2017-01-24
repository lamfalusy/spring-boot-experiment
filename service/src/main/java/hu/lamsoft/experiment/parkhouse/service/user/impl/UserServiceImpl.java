package hu.lamsoft.experiment.parkhouse.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lamsoft.experiment.parkhouse.persistence.mapper.UserMapper;
import hu.lamsoft.experiment.parkhouse.persistence.model.User;
import hu.lamsoft.experiment.parkhouse.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUser(Long id) {
		return userMapper.findUserById(id);
	}

	@Override
	public List<User> getUsers() {
		return userMapper.getAllUsers();
	}

	@Override
	public User createUser(User user) {
		userMapper.insertUser(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		userMapper.updateUser(user);
		return user;
	}

}
