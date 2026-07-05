package com.example.labresponseentity.service;

import com.example.labresponseentity.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        users.add(new User(1, "An"));
        users.add(new User(2, "Binh"));
        users.add(new User(3, "Tuan"));
        users.add(new User(4, "Tam"));

        return users;
    }
    public User findById(int id) {

        List<User> users = getAllUsers();

        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

}