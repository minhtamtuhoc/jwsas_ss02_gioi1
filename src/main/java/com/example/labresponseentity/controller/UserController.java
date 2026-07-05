package com.example.labresponseentity.controller;

import com.example.labresponseentity.model.User;
import com.example.labresponseentity.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(
            @RequestParam(required = false) String search) {

        List<User> users = userService.getAllUsers();

        if (search != null && !search.isBlank()) {

            users = users.stream()
                    .filter(user -> user.getName()
                            .toLowerCase()
                            .contains(search.toLowerCase()))
                    .toList();
        }

        return ResponseEntity.ok(users);
    }

}
