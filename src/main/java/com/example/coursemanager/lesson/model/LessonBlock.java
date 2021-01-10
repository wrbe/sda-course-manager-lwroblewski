package com.example.coursemanager.lesson.model;

import com.example.coursemanager.user.model.User;
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
public class LessonBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String subject;
    @OneToMany
    @JoinColumn(name = "lessonBlock_id")
    private List<Lesson> lessons;
    @ManyToOne
    private User teacher;

    public LessonBlock(String subject, List<Lesson> lessons, User teacher) {
        this.subject = subject;
        this.lessons = lessons;
        this.teacher = teacher;
    }
}
