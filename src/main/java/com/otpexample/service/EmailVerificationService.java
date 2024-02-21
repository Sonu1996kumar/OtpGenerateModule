package com.otpexample.service;

import com.otpexample.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class EmailVerificationService {
    @Autowired
    private UserService userService;
    static final Map<String,String> emailOtpMapping = new HashMap<>();

    public Map<String,String> verifyOtp(String email,String otp){
        String storedOtp = emailOtpMapping.get(email);

        Map<String,String> response = new HashMap<>();
        if(storedOtp!=null && storedOtp.equals(otp)){
            //Fetch user by email and mark email as verified
            //logger.info("OTP is valid. Proceeding with verification.");
            User user = userService.getUserByEmail(email);
            if(user != null){
                emailOtpMapping.remove(email);//removing the otp
                userService.verifyEmail(user);
                response.put("status","success");
                response.put("message","Email verified successfully");
            }else{
                //logger.error("Invalid OTP recieved for email: {}",email);
                response.put("status","error");
                response.put("message","User not found");
            }
        }else{
                response.put("status","error");
                response.put("message","Invalid OTP");
        }
        return response;
    }

}
