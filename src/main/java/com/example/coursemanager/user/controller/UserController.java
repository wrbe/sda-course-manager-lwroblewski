package com.example.coursemanager.user.controller;

import com.example.coursemanager.user.UserRepository;
import com.example.coursemanager.user.model.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsersList() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }


}
