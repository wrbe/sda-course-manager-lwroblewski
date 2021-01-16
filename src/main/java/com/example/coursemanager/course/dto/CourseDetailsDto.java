package com.example.coursemanager.course.dto;

import com.example.coursemanager.lesson.dto.LessonBlockDetailsDto;
import com.example.coursemanager.lesson.model.Lesson;
import com.example.coursemanager.lesson.model.LessonBlock;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CourseDetailsDto {

    private long id;
    private String name;
    private List<LessonBlockDetailsDto> lessonBlock;

}
