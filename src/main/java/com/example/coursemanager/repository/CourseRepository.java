package com.example.coursemanager.repository;

import com.example.coursemanager.model.Course;
import com.example.coursemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}