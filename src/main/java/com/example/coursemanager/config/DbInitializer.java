package com.example.coursemanager.config;

import com.example.coursemanager.model.*;
import com.example.coursemanager.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DbInitializer implements CommandLineRunner {

    private final LessonRepository lessonRepository;
    private final LessonBlockRepository lessonBlockRepository;
    private final CourseRepository courseRepository;
    private final CourseEnrollmentRepository courseEnrollmentRepository;
    private final UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        initDb();

    }

    // metoda sprawdzajaca czy jakies dane sa w bazie danych aby uniknac duplikowania rekordow

    private void initDb() {
        if ((lessonRepository.count() == 0) &
            (lessonBlockRepository.count() == 0) &
            (courseRepository.count() == 0) &
            (courseEnrollmentRepository.count() == 0) &
            (userRepository.count() == 0)) {

            User user1 = new User("login1", "pass1", Role.ADMIN, "Jan", "Kowalski", true);
            User user2 = new User("login2", "pass2", Role.TEACHER, "Zbigniew", "Moczymaka", true);
            User user3 = new User("login3", "pass3", Role.PARTICIPANT, "Sandra", "Kowalska", true);

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            Lesson lesson_db1 = new Lesson("#1 Database", LocalDate.now().minusDays(20));
            Lesson lesson_db2 = new Lesson("#2 Database", LocalDate.now().minusDays(20));
            Lesson lesson_db3 = new Lesson("#3 Database", LocalDate.now().minusDays(20));
            List<Lesson> lessons_db_list = new ArrayList<>();
            lessons_db_list.add(lesson_db1);
            lessons_db_list.add(lesson_db2);
            lessons_db_list.add(lesson_db3);

            lessonRepository.save(lesson_db1);
            lessonRepository.save(lesson_db2);
            lessonRepository.save(lesson_db3);

            Lesson lesson_test1 = new Lesson("#1 Testing in java", LocalDate.now().minusDays(24));
            Lesson lesson_test2 = new Lesson("#2 Testing in java", LocalDate.now().minusDays(24));
            Lesson lesson_test3 = new Lesson("#3 Testing in java", LocalDate.now().minusDays(24));
            List<Lesson> lessons_test_list = new ArrayList<>();
            lessons_test_list.add(lesson_test1);
            lessons_test_list.add(lesson_test2);
            lessons_test_list.add(lesson_test3);

            lessonRepository.save(lesson_test1);
            lessonRepository.save(lesson_test2);
            lessonRepository.save(lesson_test3);

            Lesson lesson_advanced1 = new Lesson("#1 Advanced programming in Java", LocalDate.now().minusDays(30));
            Lesson lesson_advanced2 = new Lesson("#2 Advanced programming in Java", LocalDate.now().minusDays(30));
            Lesson lesson_advanced3 = new Lesson("#3 Advanced programming in Java", LocalDate.now().minusDays(30));
            List<Lesson> lessons_advanced_list = new ArrayList<>();
            lessons_advanced_list.add(lesson_advanced1);
            lessons_advanced_list.add(lesson_advanced2);
            lessons_advanced_list.add(lesson_advanced3);

            lessonRepository.save(lesson_advanced1);
            lessonRepository.save(lesson_advanced2);
            lessonRepository.save(lesson_advanced3);

            LessonBlock java_db = new LessonBlock("Java", lessons_db_list, user2);
            LessonBlock java_test = new LessonBlock("Java", lessons_test_list, user2);
            LessonBlock java_advanced = new LessonBlock("Java", lessons_advanced_list, user2);

            lessonBlockRepository.save(java_db);
            lessonBlockRepository.save(java_test);
            lessonBlockRepository.save(java_advanced);

            List<LessonBlock> javaLessonsBlockList = new ArrayList<>();
            javaLessonsBlockList.add(java_db);
            javaLessonsBlockList.add(java_test);
            javaLessonsBlockList.add(java_advanced);

            Course java = new Course("Java from scratch", javaLessonsBlockList);

            courseRepository.save(java);

            CourseEnrollment javaEnrollment = new CourseEnrollment(LocalDate.now(), user3, java);

            courseEnrollmentRepository.save(javaEnrollment);
        }
    }
}

