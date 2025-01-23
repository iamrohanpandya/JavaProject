package com.practice.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.practice.dto.UserDto;
import com.practice.practice.service.UserService;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/users")

public class RestController {
	
	
	 @Autowired
	    private UserService userService;
	 
	 
	  // CREATE USER
	    @PostMapping
	    public UserDto createUser(@RequestBody UserDto userDto) {
	        return userService.createUser(userDto);
	    }
	    
	  // GET ALL USERS
	    @GetMapping
	    public List<UserDto> getAllUsers() {
	        return userService.getAllUsers();
	    }

	    // GET USER BY ID
	    @GetMapping("/{id}")
	    public UserDto getUserById(@PathVariable Long id) {
	        return userService.getUserById(id);
	    }

	    // UPDATE USER
	    @PutMapping("/{id}")
	    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
	        return userService.updateUser(id, userDto);
	    }

	    // DELETE USER
	    @DeleteMapping("/{id}")
	    public void deleteUser(@PathVariable Long id) {
	        userService.deleteUser(id);
	    }
	
	

}
