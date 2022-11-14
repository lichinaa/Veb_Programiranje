package mk.ukim.finki.aud1.repository;

import mk.ukim.finki.aud1.Model.Teacher;
import mk.ukim.finki.aud1.bootsrap.DataHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeacherRepository {

    public List<Teacher> findAll(){
        return DataHolder.teachers;
    }

    public Optional<Teacher> findById(Long id){
        return DataHolder.teachers.stream()
                .filter(i->i.getId().equals(id)).findFirst();
    }
}
