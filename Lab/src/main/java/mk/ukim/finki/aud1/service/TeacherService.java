package mk.ukim.finki.aud1.service;

import mk.ukim.finki.aud1.Model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    public List<Teacher> findAll();

    Optional<Teacher> findById(Long id);
}
