package mk.ukim.finki.aud1.service.Impl;


import mk.ukim.finki.aud1.Model.Course;
import mk.ukim.finki.aud1.Model.Teacher;
import mk.ukim.finki.aud1.Model.exceptions.TeacherNotFoundExecption;
import mk.ukim.finki.aud1.repository.CourseRepository;
import mk.ukim.finki.aud1.repository.TeacherRepository;
import mk.ukim.finki.aud1.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final TeacherRepository teacherRepository;

    public CourseServiceImpl(CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }

  /*  @Override
    public List<Course> listStudentsByCourse(Long courseId) {
        return courseRepository.findAllCourses();
    }
  */

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        return null;
    }

    @Override
    public List<Course> listAll() {
        return courseRepository.findAllCourses();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return this.courseRepository.findById(id);
    }

   /* @Override
    public Course create(String name, String description) {
        if(name==null && name.isEmpty()){
            throw new IllegalArgumentException();
        }
        Course c = new Course(name, description);
        courseRepository.save(name, description);
        return c;
    }
*/
    @Override
    public Optional<Course> save(String name, String desc, Long id) {
        Teacher teacher = this.teacherRepository.findById(id)
                .orElseThrow(()->new TeacherNotFoundExecption(id));

        return this.courseRepository.save(name, desc, teacher);
    }

    @Override
    public void deleteById(Long id) {
        this.courseRepository.deleteById(id);
    }
}
