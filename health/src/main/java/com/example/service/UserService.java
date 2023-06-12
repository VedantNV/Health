package com.example.service;

import org.springframework.stereotype.Service;

import com.example.exception.CustomException;
import com.example.pojo.HealthData;
import com.example.pojo.User;
import com.example.repo.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
       User u1 = userRepo.findbyid(user.getId());
       
   	if(u1!=null && user.getAge()>=65) {
   		return userRepo.save(u1);
   	}
   	
		 throw new CustomException("inaccurate data entered");
    }

    public User getUserByUsername(String username) {
    	 User u1 = userRepo.findByUsername(username);
         
    	   	if(u1!=null && u1.getAge()>=65) {
    	   		return userRepo.save(u1);
    	   	}  
    	
    	   	throw new CustomException("data not found");
    }
}

