package hu.lamsoft.experiment.parkhouse.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.lamsoft.experiment.parkhouse.persistence.mapper.UserMapper;
import hu.lamsoft.experiment.parkhouse.persistence.model.User;
import hu.lamsoft.experiment.parkhouse.service.user.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findById(Long id) {
		return userMapper.findUserById(id);
	}

	@Override
	public List<User> findAll() {
		return userMapper.getAllUsers();
	}

	@Override
	public User create(User user) {
		userMapper.insertUser(user);
		return user;
	}

	@Override
	public User update(User user) {
		userMapper.updateUser(user);
		return user;
	}

}
