package com.example.coursemanager.user.dto;

import com.example.coursemanager.user.model.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {

    private Long id;
    private Role role;
    private String firstName;
    private String lastName;
    private boolean active;

}
