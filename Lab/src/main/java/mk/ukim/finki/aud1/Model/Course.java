package mk.ukim.finki.aud1.Model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Course {
    private Long Id;
    private String name;
    private String description;
    public static List<Student> students;

    private Teacher teacher;

    public Course(String name, String description) {
        this.Id = (long) (Math.random()*1000);
        this.name = name;
        this.description = description;
    }

}

