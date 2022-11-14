package mk.ukim.finki.aud1.repository;

import mk.ukim.finki.aud1.Model.Course;
import mk.ukim.finki.aud1.Model.Student;
import mk.ukim.finki.aud1.bootsrap.DataHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    public List<Student> findAllStudents(){
        return DataHolder.students;
    }
    public List<Student> findAllByNameOrSurname(String text){
        return Course.students.stream().filter(r->r.getName().contains(text)
                || r.getSurname().contains(text)).collect(Collectors.toList());
    }

    public Student save(String username, String password, String name, String surname){
        if (username == null || name == null || surname == null || password == null)
            return null;
        DataHolder.students.removeIf(s -> s.getUsername().equals(username));
        Student student = new Student(username, password, name, surname);
        DataHolder.students.add(student);
        return student;
    }

}
