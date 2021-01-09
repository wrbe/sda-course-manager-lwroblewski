package com.example.coursemanager.repository;

import com.example.coursemanager.model.Course;
import com.example.coursemanager.model.CourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, Long> {

}
