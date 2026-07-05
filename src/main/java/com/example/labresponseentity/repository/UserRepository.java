package com.example.labresponseentity.repository;

import com.example.labresponseentity.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1, "An"));
        users.add(new User(2, "Binh"));
        users.add(new User(3, "Tam"));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {

        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    public User save(User user) {
        users.add(user);
        return user;
    }

    public User save(int id, User newUser) {

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getId() == id) {

                newUser.setId(id);

                users.set(i, newUser);

                return newUser;
            }
        }

        return null;
    }

    public User deleteById(int id) {

        User user = findById(id);

        if (user != null) {
            users.remove(user);
            return user;
        }

        return null;
    }
}