package com.example.TheWareHouse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserDAO {

	@Autowired
	private UserRepo srep;

	public UserDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addUser(User user) {
		srep.save(user);
	

	}

	public User getUser(String username) {
		Optional<User> sopt = srep.findById(username);

		if (sopt.isPresent())
			return sopt.get();
		else
			return null;

	}

	public void updateUser(User user) {

		srep.save(user);

	}

	public void removeUser(String username) {

		srep.deleteById(username);

	}

	public List<User> listUsers() {

		List<User> users = srep.findAll();
		return users;
	}

}
