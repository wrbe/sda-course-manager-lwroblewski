package com.example.coursemanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "course_id")
    private List<LessonBlock> lessonBlocks;

    public Course(String name, List<LessonBlock> lessonBlocks) {
        this.name = name;
        this.lessonBlocks = lessonBlocks;
    }
}
