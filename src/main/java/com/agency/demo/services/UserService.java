package com.agency.demo.services;

import com.agency.demo.models.User;
import com.agency.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User u){
        userRepository.save(u);
    }

    public User getUserByNumber(String number){
        return userRepository.findUserByPhoneNumber(number).get();
    }
}
