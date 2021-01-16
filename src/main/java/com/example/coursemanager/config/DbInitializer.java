package com.example.coursemanager.config;

import com.example.coursemanager.course.model.Course;
import com.example.coursemanager.course.model.CourseEnrollment;
import com.example.coursemanager.course.CourseEnrollmentRepository;
import com.example.coursemanager.course.CourseRepository;
import com.example.coursemanager.lesson.model.Lesson;
import com.example.coursemanager.lesson.model.LessonBlock;
import com.example.coursemanager.lesson.LessonBlockRepository;
import com.example.coursemanager.lesson.LessonRepository;
import com.example.coursemanager.user.model.Role;
import com.example.coursemanager.user.model.User;
import com.example.coursemanager.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

//        flushDatabase();
//          initDb();

        if ((lessonRepository.count() == 0) &
                (lessonBlockRepository.count() == 0) &
                (courseRepository.count() == 0) &
                (courseEnrollmentRepository.count() == 0) &
                (userRepository.count() == 0)) {

        initUser("admin", "admin", Role.ADMIN, "Admin", "Administrator");
        initUser("user", "user", Role.PARTICIPANT, "Participant", "unknown");
        initUser("teacher", "teacher", Role.TEACHER, "Teacher", "unknown");

        initCourse("Java", "PL");
        initCourse("Java", "EN");
        initCourse("Phyton", "PL");
        initCourse("PHP", "PL");

//        initLesson("Spring", 40);
//        initLesson("MySql", 20);
//        initLesson("Testing", 10);
//
//        initBlocks("Advanced");
//        initBlocks("Database");
//        initBlocks("Testing");
    } }

    // metoda sprawdzajaca czy jakies dane sa w bazie danych aby uniknac duplikowania rekordow

    private void initDb() {
        if ((lessonRepository.count() == 0) &
            (lessonBlockRepository.count() == 0) &
            (courseRepository.count() == 0) &
            (courseEnrollmentRepository.count() == 0) &
            (userRepository.count() == 0)) {

            User user1 = new User("login1", "pass1", Role.ADMIN, "Jan", "Kowalski");
            User user2 = new User("login2", "pass2", Role.TEACHER, "Zbigniew", "Moczymaka");
            User user3 = new User("login3", "pass3", Role.PARTICIPANT, "Sandra", "Kowalska");

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
            Course phyton = new Course("Phyton from scratch", javaLessonsBlockList);

            courseRepository.save(java);

            CourseEnrollment javaEnrollment = new CourseEnrollment(LocalDate.now(), user3, java);

            courseEnrollmentRepository.save(javaEnrollment);
        }
    }

    private List<Lesson> initLesson(String name, int count) {
        return IntStream.range(0, count).mapToObj(i -> {
            Lesson lesson = new Lesson(name + " #" + i, LocalDate.now().minusDays(31 - i));
            lessonRepository.save(lesson);
            return lesson;
        }).collect(Collectors.toList());
    }

//    private List<Lesson> initLessons(String subject, int count) {
//        return IntStream.range(0, count).mapToObj(i -> {
//            Lesson lesson = new Lesson();
//            lesson.setSubject(subject + " " + i);
//            lesson.setDate(LocalDate.now().minusDays(31 - i));
//            lessonRepository.save(lesson);
//            return lesson;
//        }).collect(Collectors.toList());
//    }

    private User initUser(String login, String pass, Role type, String firstName, String lastName) {
        User user = new User(login, pass, type, firstName, lastName);
        user.setActive(true);
        userRepository.save(user);
        return user;
    }
    private Course initCourse(String name, String coursePrefix) {
        Course course = new Course();
        course.setName(name);
        course.setLessonBlocks(initBlocks(coursePrefix));
        courseRepository.save(course);
        return course;
    }

    private List<LessonBlock> initBlocks(String coursePrefix) {
        LessonBlock block_test = new LessonBlock();
        LessonBlock block_db = new LessonBlock();
        LessonBlock block_java = new LessonBlock();

        block_java.setSubject(coursePrefix + " java");
        block_java.setLessons(initLesson("java", 20));
        lessonBlockRepository.save(block_java);

        block_db.setSubject(coursePrefix + " db");
        block_db.setLessons(initLesson("db", 6));
        lessonBlockRepository.save(block_db);

        block_test.setSubject(coursePrefix + " test");
        block_test.setLessons(initLesson("test", 4));
        lessonBlockRepository.save(block_test);

        return List.of(block_java, block_db, block_test);
    }

    private void flushDatabase() {
        courseEnrollmentRepository.deleteAll();
        courseRepository.deleteAll();
        lessonBlockRepository.deleteAll();
        lessonRepository.deleteAll();
        userRepository.deleteAll();
    }


}

