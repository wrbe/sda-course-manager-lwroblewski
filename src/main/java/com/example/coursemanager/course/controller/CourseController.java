package com.example.coursemanager.course.controller;

import com.example.coursemanager.course.CourseEnrollmentRepository;
import com.example.coursemanager.course.dto.CourseDetailsDto;
import com.example.coursemanager.course.dto.CourseDtoMapper;
import com.example.coursemanager.course.CourseRepository;
import com.example.coursemanager.course.dto.CourseDto;
import com.example.coursemanager.course.dto.CourseEnrollmentForm;
import com.example.coursemanager.course.model.Course;
import com.example.coursemanager.course.model.CourseEnrollment;
import com.example.coursemanager.user.UserRepository;
import com.example.coursemanager.user.model.User;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseEnrollmentRepository courseEnrollmentRepository;

    @GetMapping("/courses")
    public List<Course> getCoursesList() {
        return courseRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/courses/{id}")
    public CourseDto getCourseById(@PathVariable Long id) {
        return CourseDtoMapper.mapCourseToDto(courseRepository.findById(id).get());
    }

    @GetMapping("/courses/info/{id}")
    public CourseDetailsDto getCourseDetailById(@PathVariable Long id) {
        return CourseDtoMapper.mapCourseToDetailDto(courseRepository.findById(id).get());
    }

    @PostMapping("/enrollments/")
    public CourseEnrollment enrollParticipant(@RequestBody CourseEnrollmentForm newEnrollment) throws NotFoundException {
        Course course = courseRepository.findById(newEnrollment.getCourseId())
                .orElseThrow(() -> new NotFoundException("course not found"));

        User participant = userRepository.findById(newEnrollment.getParticipantId())
                .orElseThrow(() -> new NotFoundException("course not found"));

        CourseEnrollment enrollment = new CourseEnrollment();
        enrollment.setCourse(course);
        enrollment.setParticipant(participant);
        CourseEnrollment savedEnrollment = courseEnrollmentRepository.save(enrollment);

        return savedEnrollment;

    }
}
