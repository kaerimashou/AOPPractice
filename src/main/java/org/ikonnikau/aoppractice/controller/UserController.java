package org.ikonnikau.aoppractice.controller;

import org.ikonnikau.aoppractice.entity.User;
import org.ikonnikau.aoppractice.service.UserService;
import org.ikonnikau.aoppractice.util.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public CustomResponse<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{firstName}")
    public CustomResponse<User> getUserByFirstName(@PathVariable String firstName) {
        return userService.getUserByFirstName(firstName);
    }

    @PostMapping("/users")
    public CustomResponse<User> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
