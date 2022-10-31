package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.bootsrap.DataHolder;
import mk.ukim.finki.wp.lab1.model.Course;
import mk.ukim.finki.wp.lab1.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    public static List<Course> courses= new ArrayList<>();

    @PostConstruct
    public  void init(){
        courses.add(new Course(1L, "Wp1", "WpDesc1"));
        courses.add(new Course(2L, "Wp2", "WpDesc2"));
        courses.add(new Course(3L, "Wp3", "WpDesc3"));
        courses.add(new Course(4L, "Wp4", "WpDesc4"));
        courses.add(new Course(5L, "Wp5", "WpDesc5"));
    }
    public List<Course> findAllCourses(){
        return courses;
    }
    public Course findById(Long courseId){
        return courses.get(Math.toIntExact(courseId));
    }
    public  Course addStudentToCourse(Student student, Course course){
        if(student==null || course==null){
            return null;
        }

        Course.students.removeIf(r->r.getName().equals(student.getName()));
        Course.students.add(student);
        courses.add(course);
        return course;
    }

    public Course save(Course c){
        DataHolder.courses.add(c);
        return  c;
    }
}
