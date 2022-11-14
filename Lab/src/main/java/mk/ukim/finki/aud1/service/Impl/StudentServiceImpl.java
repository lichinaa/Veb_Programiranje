package mk.ukim.finki.aud1.service.Impl;


import lombok.Data;
import mk.ukim.finki.aud1.Model.Student;
import mk.ukim.finki.aud1.bootsrap.DataHolder;
import mk.ukim.finki.aud1.repository.StudentRepository;
import mk.ukim.finki.aud1.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class StudentServiceImpl implements StudentService {

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
    public Student create(String name) {
        return null;
    }
    @Override
    public Student save(String username, String password, String name, String surname) {
        Student s = new Student(username,password,name,surname);
        DataHolder.students.removeIf(st->st.getUsername().equals(username));
        DataHolder.students.add(s);
        return s;
    }

}
