package mk.ukim.finki.aud1.service;


import mk.ukim.finki.aud1.Model.Student;

import java.util.List;

public interface StudentService {
    List<Student> listAll();
    List<Student> searchByNameOrSurname(String text);
    Student save(String username, String password, String name, String surname);

    Student create(String name);
}