package com.example.coursemanager.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class CourseEnrollment {

    @Id
    @GeneratedValue
    private long id;
    private LocalDate date;
    @ManyToOne
    private User participant;
    @ManyToOne
    private Course course;

}
