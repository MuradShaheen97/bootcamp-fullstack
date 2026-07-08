package com.axsos.orders.services;


import java.util.Optional;

import com.axsos.orders.models.Users;
import com.axsos.orders.repos.UserRepo;

public class UserService {
	private final UserRepo userRepo;
	public UserService(UserRepo userRepo) {
		this.userRepo=userRepo;
		// TODO Auto-generated constructor stub
	}
	public void createUser(Users user) {
		userRepo.save(user);
	}
	
	public void updateuser(Users newUser,Long id) {
		Optional<Users> user = userRepo.findById(id);
		if(user.isPresent()) {
			Users oldUser = user.get();
			oldUser.setFirstName(null);
			oldUser.setLastName(null);
			oldUser.setOrders(null);
			userRepo.save(oldUser);
		}
	}

}
