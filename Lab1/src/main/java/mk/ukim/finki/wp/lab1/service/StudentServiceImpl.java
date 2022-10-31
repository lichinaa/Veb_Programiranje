package mk.ukim.finki.wp.lab1.service;

import mk.ukim.finki.wp.lab1.model.Course;
import mk.ukim.finki.wp.lab1.model.Student;
import mk.ukim.finki.wp.lab1.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends StudentRepository implements  StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> listAll() {
        return studentRepository.findAllStudents();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text) {
        return studentRepository.findAllByNameOrSurname(text);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        Student x=new Student(username, password, name, surname);
        Course.students.add(new Student(username, password, name, surname));
        return x;
    }
}
