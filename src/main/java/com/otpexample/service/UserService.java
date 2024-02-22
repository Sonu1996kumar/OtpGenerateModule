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
//verify user exist in your db or not
    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;

    }

    public void verifyEmail(User user) {
        user.setEmailVerified(true);
        userRepository.save(user);

    }

    public boolean isEmailVerfied(String email) {
        User user = userRepository.findByEmail(email);
        return user !=null && user.isEmailVerified();
    }
}
