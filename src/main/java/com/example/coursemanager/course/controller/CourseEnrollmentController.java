package com.example.coursemanager.course.controller;

import com.example.coursemanager.course.CourseEnrollmentRepository;
import com.example.coursemanager.course.model.CourseEnrollment;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseEnrollmentController {

    private final CourseEnrollmentRepository courseEnrollmentRepository;

    @GetMapping("/enrollments")
    public List<CourseEnrollment> getAllCourseEnrollments() {
        return courseEnrollmentRepository.findAll();
    }

    @GetMapping("/enrollments/{id}")
    public CourseEnrollment getCourseEnrollmentById(@PathVariable Long id) {
        return courseEnrollmentRepository.findById(id).get();
    }
}
