package mk.ukim.finki.wp.lab1.service;

import lombok.Data;
import mk.ukim.finki.wp.lab1.model.Course;
import mk.ukim.finki.wp.lab1.model.Student;
import mk.ukim.finki.wp.lab1.repository.CourseRepository;
import mk.ukim.finki.wp.lab1.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return null;
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        return null;
    }

    @Override
    public List<Course> listAll() {
        return courseRepository.findAllCourses();
    }

    @Override
    public Course create(Long Id, String name, String desc) {
        Course c = new Course(Id, name, desc);
        courseRepository.save(c);
        return c;
    }

}
