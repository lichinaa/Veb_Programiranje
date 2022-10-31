package mk.ukim.finki.wp.lab1.service;

import mk.ukim.finki.wp.lab1.model.Course;
import mk.ukim.finki.wp.lab1.model.Student;

import java.util.List;

public interface CourseService {
    List<Student> listStudentsByCourse(Long courseId);
    Course addStudentInCourse(String username, Long courseId);

    List<Course> listAll();

    Course create(Long id,String name, String desc);
}
