package com.example.coursemanager.lesson;

import com.example.coursemanager.lesson.dto.LessonBlockDetailsDto;
import com.example.coursemanager.lesson.model.LessonBlock;
import com.example.coursemanager.user.model.User;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LessonBlockDetailsMapper {

    public static List<LessonBlockDetailsDto> mapToLessonBlockDetailsDtos(List<LessonBlock> lessonBlocks) {
        return lessonBlocks.stream()
                .map(lessonBlock -> mapToLessonBlockDetailsDto(lessonBlock))
                .collect(Collectors.toList());
    }

    public static LessonBlockDetailsDto mapToLessonBlockDetailsDto(LessonBlock lessonBlock) {
        return LessonBlockDetailsDto.builder()
                .id(lessonBlock.getId())
                .subject(lessonBlock.getSubject())
                .lessons(new ArrayList<>(lessonBlock.getLessons()))
                .teacherName(getTeacherName(lessonBlock))
                .teacherId(getTeacherId(lessonBlock))
                .build();
    }

    private static long getTeacherId(LessonBlock block) {
        return Optional.ofNullable(block)
                .map(LessonBlock::getTeacher)
                .map(User::getId)
                .orElse(0L);
    }

    private static String getTeacherName(LessonBlock block) {
        return Optional.ofNullable(block)
                .map(LessonBlock::getTeacher)
                .map(u -> String.format("%s %s", u.getFirstName(), u.getLastName()))
                .orElse("");
    }

}
