package com.example.coursemanager.lesson.controller;

import com.example.coursemanager.lesson.LessonBlockDetailsMapper;
import com.example.coursemanager.lesson.LessonBlockRepository;
import com.example.coursemanager.lesson.LessonRepository;
import com.example.coursemanager.lesson.dto.LessonBlockDetailsDto;
import com.example.coursemanager.lesson.dto.LessonBlockUpdateForm;
import com.example.coursemanager.lesson.model.Lesson;
import com.example.coursemanager.lesson.model.LessonBlock;
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
public class LessonController {

    private final LessonRepository lessonRepository;
    private final LessonBlockRepository lessonBlockRepository;
    private final UserRepository userRepository;

    @GetMapping("/lessons")
    public List<Lesson> getLessonList() {
        return lessonRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/lessonblocks")
    public List<LessonBlock> getLessonBlocks() {
        return lessonBlockRepository.findAll().stream().collect(Collectors.toList());
    }

    @PutMapping("/lessonblocks/{id}")
    public LessonBlockDetailsDto updateLessonBlock(@PathVariable Long id, @RequestBody LessonBlockUpdateForm newLessonBlock) throws NotFoundException {

        LessonBlock lessonBlock = lessonBlockRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("lesson block not found"));

        lessonBlock.setSubject(newLessonBlock.getSubject());

        User teacher = userRepository.findById(newLessonBlock.getTeacherId())
                .orElseThrow(() -> new NotFoundException("teacher user not found"));

        lessonBlock.setTeacher(teacher);

        LessonBlock updatedLessonBlock = lessonBlockRepository.save(lessonBlock);

        return LessonBlockDetailsMapper.mapToLessonBlockDetailsDto(updatedLessonBlock);
    }


}
