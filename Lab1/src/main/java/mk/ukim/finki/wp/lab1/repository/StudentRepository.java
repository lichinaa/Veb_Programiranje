package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.model.Course;
import mk.ukim.finki.wp.lab1.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import java.util.List;
import java.util.stream.Collectors;


@Component
@Repository
public class StudentRepository {

    @PostConstruct
    public void init(){
        Course.students.add(new Student("111", "pass1", "AA", "aa"));
        Course.students.add(new Student("222", "pass2", "BB", "bb"));
        Course.students.add(new Student("333", "pass3", "CC", "cc"));
        Course.students.add(new Student("444", "pass4", "DD", "dd"));
        Course.students.add(new Student("555", "pass5", "EE", "ee"));
    }
    public List<Student> findAllStudents(){
        return Course.students;
    }

    public List<Student> findAllByNameOrSurname(String text){
        return Course.students.stream().filter(r->r.getName().contains(text)
                || r.getSurname().contains(text)).collect(Collectors.toList());
    }


}
