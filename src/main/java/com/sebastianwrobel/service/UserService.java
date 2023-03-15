package com.sebastianwrobel.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianwrobel.dto.User;
import com.sebastianwrobel.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	Long userId = 1L;
	
	public Set<User> getUsers() {
		return userRepo.getUsers();
		
	}
	public User addUser(User user) {

		user.setUserId(userId);
		userId++;
		return userRepo.addUser(user);
		
	}

}

