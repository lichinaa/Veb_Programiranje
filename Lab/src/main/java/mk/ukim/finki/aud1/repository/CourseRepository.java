package mk.ukim.finki.aud1.repository;

import mk.ukim.finki.aud1.Model.Course;
import mk.ukim.finki.aud1.Model.Student;
import mk.ukim.finki.aud1.Model.Teacher;
import mk.ukim.finki.aud1.bootsrap.DataHolder;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository  //se prezvemaat podatoci od nekoj si storage
public class CourseRepository {

    public List<Course> findAllCourses(){
        return DataHolder.courses.stream().sorted(Comparator.comparing(Course::getName, (x,y) -> x.compareTo(y))).collect(Collectors.toList());
    }
    public Optional<Course> findById(Long courseId){
       return DataHolder.courses.stream().filter(i->i.getId().equals(courseId)).findFirst();
    }
/*
    public List<Student> findAllStudentsByCourse(Long courseId) {
        return DataHolder.courses.stream().filter(c -> c.getCourseId() == courseId).findFirst().get().getStudents();
    }
*/
    public  Course addStudentToCourse(Student student, Course course){
        if(student==null || course==null){
            return null;
        }
        Course.students.removeIf(r->r.getName().equals(student.getName()));
        Course.students.add(student);
        DataHolder.courses.add(course);
        return course;
    }
  /*  public Course save(Course c){
        if(c==null || c.getName().isEmpty()){
            return null;
        }
        DataHolder.courses.removeIf(i->i.getName().equals(c.getName()));
        DataHolder.courses.add(c);
        return c;
    }*/
    public Optional<Course> save(String name, String description, Teacher teacher){
        DataHolder.courses.removeIf(i->i.getName().equals(name));
        Course course = new Course(name, description);
        DataHolder.courses.add(course);
        return Optional.of(course);
    }

    public void deleteById(Long id){
        DataHolder.courses.removeIf(i->i.getId().equals(id));
    }
}
