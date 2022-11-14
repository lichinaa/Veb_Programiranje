package mk.ukim.finki.aud1.service;

import mk.ukim.finki.aud1.Model.Course;
import mk.ukim.finki.aud1.Model.Student;

import java.util.List;
import java.util.Optional;

public interface CourseService {
  //  List<Student> listStudentsByCourse(Long courseId);
    Course addStudentInCourse(String username, Long courseId);
    List<Course> listAll();

    Optional<Course> findById(Long id);
   // Course create(String name, String description);

    Optional<Course> save(String name, String desc, Long id);

    void deleteById(Long id);
}
