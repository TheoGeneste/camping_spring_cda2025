package com.cda.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.camping.model.User;
import com.cda.camping.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	public User getUser(Integer id){
		return userRepository.findById(id);
	}

	public void createUser(User u){
		userRepository.save(u);
	}

	public void updateUser(User u){
		userRepository.update(u);
	}

	public void deleteUser(Integer id){
		userRepository.delete(id);
	}
}
