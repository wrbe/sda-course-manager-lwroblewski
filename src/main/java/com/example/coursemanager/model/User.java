package com.example.coursemanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String login;
    private String pass;
    @Enumerated(value = EnumType.STRING) // Zmieniamy enuma z INTa na STRINGa
    private Role type;
    private String firstName;
    private String lastName;
    private boolean active;

    public User(String login, String pass, Role type, String firstName, String lastName, boolean active) {
        this.login = login;
        this.pass = pass;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
    }
}
