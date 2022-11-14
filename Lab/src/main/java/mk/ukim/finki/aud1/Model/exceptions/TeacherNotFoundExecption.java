package mk.ukim.finki.aud1.Model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class TeacherNotFoundExecption extends RuntimeException{
    public TeacherNotFoundExecption(Long id){
        super(String.format("Teacher with id %d was not found", id));
    }
}
