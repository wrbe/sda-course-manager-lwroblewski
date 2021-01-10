package com.example.coursemanager.course.model;
import com.example.coursemanager.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    @ManyToOne
    private User participant;
    @ManyToOne
    private Course course;

    public CourseEnrollment(LocalDate date, User participant, Course course) {
        this.date = date;
        this.participant = participant;
        this.course = course;
    }
}
