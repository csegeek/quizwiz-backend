package com.quizwiz.quizwizbackend.controller;

import com.quizwiz.quizwizbackend.entities.Role;
import com.quizwiz.quizwizbackend.entities.User;
import com.quizwiz.quizwizbackend.entities.UserRole;
import com.quizwiz.quizwizbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        user.setProfile("default.png");
        //encoding password with bcryptpasswordencoder
        user.setPassword(this.encoder.encode(user.getPassword()));
        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        roles.add(userRole);
        return this.userService.createUser(user, roles);

    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    //delete the user by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
    }


}
