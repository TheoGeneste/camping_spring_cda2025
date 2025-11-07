package com.cda.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.camping.config.JwtUtil;
import com.cda.camping.config.PasswordUtil;
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
		u.setPassword(PasswordUtil.encode(u.getPassword()));
		userRepository.save(u);
	}

	public void updateUser(User u){
		userRepository.update(u);
	}

	public void deleteUser(Integer id){
		userRepository.delete(id);
	}

    public String login(User user) {
        User currentUser = userRepository.findByLogin(user.getLogin());
		if (currentUser != null && PasswordUtil.matches(user.getPassword(), currentUser.getPassword())) {
			return JwtUtil.generateToken(currentUser.getLogin());
		}
		return null;
    }
}
