package com.example.coursemanager.user.controller;

import com.example.coursemanager.user.UserRepository;
import com.example.coursemanager.user.dto.UserDto;
import com.example.coursemanager.user.dto.UserDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200") // Nie dziala przy Spring Security domyslnie, do dajemy do Configa .cors()
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public List<UserDto> getUsersList() {
        return UserDtoMapper.mapToUserDtos(userRepository.findAll());
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return UserDtoMapper.mapToUserDto(userRepository.findById(id).get());
    }


}
