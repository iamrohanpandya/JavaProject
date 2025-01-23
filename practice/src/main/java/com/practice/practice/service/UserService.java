package com.practice.practice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.practice.dto.UserDto;
import com.practice.practice.model.User;
import com.practice.practice.repository.UserRepository;

import ma.glasnost.orika.MapperFacade;

@Service
public class UserService {
	
	
    @Autowired
    private UserRepository userRepository;
    
    
    @Autowired
    private MapperFacade mapperFacade;
    
    
    // CREATE USER
    public UserDto createUser(UserDto userDto) {
        User user = mapperFacade.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        return mapperFacade.map(savedUser, UserDto.class);
    }
    
 // GET ALL USERS
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> mapperFacade.map(user, UserDto.class))
                .collect(Collectors.toList());
    }
    
    
    // GET USER BY ID
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        return mapperFacade.map(user, UserDto.class);
    }
    
 // UPDATE USER
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        mapperFacade.map(userDto, user);
        User updatedUser = userRepository.save(user);
        return mapperFacade.map(updatedUser, UserDto.class);
    }
    
    
 // DELETE USER
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    

}
