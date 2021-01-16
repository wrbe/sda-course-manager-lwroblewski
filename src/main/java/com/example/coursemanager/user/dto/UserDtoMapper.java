package com.example.coursemanager.user.dto;


import com.example.coursemanager.user.dto.UserDto;
import com.example.coursemanager.user.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDtoMapper {

    public static List<UserDto> mapToUserDtos(List<User> users) {
        return users.stream()
                .map(user -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    public static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .role(user.getType())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .active(user.isActive())
                .build();
    }


}
