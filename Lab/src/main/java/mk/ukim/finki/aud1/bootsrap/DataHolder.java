package mk.ukim.finki.aud1.bootsrap;

import lombok.Getter;
import mk.ukim.finki.aud1.Model.Course;
import mk.ukim.finki.aud1.Model.Student;
import mk.ukim.finki.aud1.Model.Teacher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component //da se instancira koga kje se startuva samata app
@Getter
public class DataHolder {
    public static List<Course> courses=new ArrayList<>();

    public static List<Student> students = new ArrayList<>();

    public static List<Teacher> teachers = new ArrayList<>();


    @PostConstruct  //konstata za init za da se povika vednas koga kje se startuva stranicata
    public void init(){
        courses.add(new Course("Web programiranje", "Веб Програмирање2022/2023"));
        courses.add(new Course( "Bazi na podatoci", "Веб Програмирање2022/2023"));
        courses.add(new Course( "Napredno programiranje", "Веб Програмирање2022/2023"));
        courses.add(new Course( "Algoritmi", "Веб Програмирање2022/2023"));

        students.add(new Student("user1", "pass1", "Amra", "prez1"));
        students.add(new Student("user2", "pass2", "Ana", "prez2"));
        students.add(new Student("user3", "pass3", "Banana", "prez3"));

        teachers.add(new Teacher("TeacherName 1", "TeacherSurname 1"));
        teachers.add(new Teacher("TeacherName 2", "TeacherSurname 2"));
        teachers.add(new Teacher("TeacherName 3", "TeacherSurname 3"));
        teachers.add(new Teacher("TeacherName 4", "TeacherSurname 4"));
        teachers.add(new Teacher("TeacherName 5", "TeacherSurname 5"));

    }

}
