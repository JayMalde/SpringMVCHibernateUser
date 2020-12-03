package com.aptechkharghar.service;

import com.aptechkharghar.entities.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptechkharghar.DAO.UserDAO;
@Service
public class UserService {
	@Autowired
	UserDAO userDAO = new UserDAO();
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
	
	public User getUserById(Integer userId) {
		return userDAO.getUserById(userId);
	}
	
	public void deleteUser(User userObj) {
		userDAO.deleteUser(userObj);
	}
}
