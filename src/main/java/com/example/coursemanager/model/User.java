package com.example.coursemanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {

    @GeneratedValue
    @Id
    private long id;
    private String login;
    private String pass;
    @Enumerated(value = EnumType.STRING) // Zmieniamy enuma z INTa na STRINGa
    private Role type;
    private String firstName;
    private String lastName;
    private boolean active;


}
