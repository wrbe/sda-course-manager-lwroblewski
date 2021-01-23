package com.example.coursemanager.user;

import com.example.coursemanager.user.model.Role;
import com.example.coursemanager.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByType(Role role);

}
