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
public class LessonBlock {

    @Id
    @GeneratedValue
    private long id;
    private String subject;
    @OneToMany
    @JoinColumn(name = "lessonBlock_id")
    private List<Lesson> lessons;
    @ManyToOne
    private User teacher;

}
