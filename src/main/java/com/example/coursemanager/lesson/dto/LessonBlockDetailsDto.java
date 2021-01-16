package com.example.coursemanager.lesson.dto;

import com.example.coursemanager.lesson.model.Lesson;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class LessonBlockDetailsDto {

    private long id;
    private String subject;
    private List<Lesson> lessons;
    private String teacherName;
    private long teacherId;

}
