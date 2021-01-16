package com.example.coursemanager.course.dto;

import com.example.coursemanager.course.model.Course;
import com.example.coursemanager.lesson.LessonBlockDetailsMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CourseDtoMapper {

    public static List<CourseDto> mapCourseToDtoList(List<Course> courses) {

        return courses.stream()
                .map(course -> mapCourseToDto(course))
                .collect(Collectors.toList());
    }

    public static CourseDto mapCourseToDto(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());

        int hourCount = course.getLessonBlocks().stream()
                .mapToInt(block -> block.getLessons().size() * 8)
                .sum();

        courseDto.setCourseLength(hourCount);

        return courseDto;
    }

    public static CourseDetailsDto mapCourseToDetailDto(Course course) {

        return CourseDetailsDto.builder()
                .id(course.getId())
                .name(course.getName())
                .lessonBlock(LessonBlockDetailsMapper.mapToLessonBlockDetailsDtos(course.getLessonBlocks())).build();
    }

//    public static CourseDetailsDto mapCourseDetailsToDto(Course course) {
//        CourseDetailsDto courseDto = new CourseDetailsDto();
//        courseDto.setId(course.getId());
//        courseDto.setName(course.getName());
//        courseDto.setLessonBlocks();
//
//        return courseDto;
//    }

}
