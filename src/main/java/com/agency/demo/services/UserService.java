package com.agency.demo.services;

import com.agency.demo.enums.UserRole;
import com.agency.demo.models.User;
import com.agency.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

    public User getUserById(long id){
        return userRepository.findById(id).get();
    }

    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

    public List<User> getUsersWithDefaultRole(){
        return userRepository.findUsersByRoleEquals(UserRole.USER);
    }
}
