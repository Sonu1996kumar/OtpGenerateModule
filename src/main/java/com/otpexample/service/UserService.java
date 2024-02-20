package com.otpexample.service;

import com.otpexample.entity.User;
import com.otpexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        //Save the user to the database
        return userRepository.save(user);
    }
}