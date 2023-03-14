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
	
	Long userId = 4L;
	
	public Set<User> getUsers() {
		return userRepo.getUsers();
		
	}
	public User addUser(User user) {
//		This should always auto increment but starting at 4 because I have the 3 users already.
//		=> we should only have to do a Post request with userName as the only info coming in.
		user.setUserId(userId);
		userId++;
		return userRepo.addUser(user);
		
	}

}

