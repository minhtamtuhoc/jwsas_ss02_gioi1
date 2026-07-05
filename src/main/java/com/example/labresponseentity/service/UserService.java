package com.example.labresponseentity.service;

import com.example.labresponseentity.model.User;
import com.example.labresponseentity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(int id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int id, User user) {
        return userRepository.save(id, user);
    }

    public User deleteUserById(int id) {
        return userRepository.deleteById(id);
    }
}