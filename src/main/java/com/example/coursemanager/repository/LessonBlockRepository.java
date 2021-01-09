package com.example.coursemanager.repository;

import com.example.coursemanager.model.Lesson;
import com.example.coursemanager.model.LessonBlock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonBlockRepository extends JpaRepository<LessonBlock, Long> {
}
