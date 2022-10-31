package mk.ukim.finki.wp.lab1.bootsrap;

import jdk.jfr.Category;
import mk.ukim.finki.wp.lab1.model.Course;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    public static List<Course> courses=new ArrayList<>();

    @PostConstruct
    public void init(){
        courses.add(new Course(100L, "Веб Програмирање", "Веб Програмирање2022/2023"));
    }
}
