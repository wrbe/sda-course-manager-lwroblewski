package com.example.coursemanager.course.controller;

import com.example.coursemanager.course.dto.CourseDetailsDto;
import com.example.coursemanager.course.dto.CourseDtoMapper;
import com.example.coursemanager.course.CourseRepository;
import com.example.coursemanager.course.dto.CourseDto;
import com.example.coursemanager.course.model.Course;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;

    @GetMapping("/courses")
    public List<Course> getCoursesList() {
        return courseRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/courses/{id}")
    public CourseDto getCourseById(@PathVariable Long id) { return CourseDtoMapper.mapCourseToDto(courseRepository.findById(id).get()); }

    @GetMapping("/courses/info/{id}")
    public CourseDetailsDto getCourseDetailById(@PathVariable Long id) { return CourseDtoMapper.mapCourseToDetailDto(courseRepository.findById(id).get()); }

}
