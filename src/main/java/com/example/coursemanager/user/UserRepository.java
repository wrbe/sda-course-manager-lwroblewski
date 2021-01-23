package com.example.coursemanager.user;

import com.example.coursemanager.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
