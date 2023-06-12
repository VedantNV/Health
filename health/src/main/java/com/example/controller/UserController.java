package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="http://localhost:5500")
	public class UserController {
	    @Autowired
	    UserService userService;

	    public UserController(UserService userService) {
	        this.userService = userService;
	    }

	    @PostMapping("/adduser")
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	    	System.out.println("Here "+user);
	        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	    }

	    @GetMapping("/{username}")
	    public ResponseEntity<User> authenticateUser(@PathVariable String username) {
	         return new ResponseEntity<User>(userService.getUserByUsername(username),HttpStatus.OK);
	    }
	}

