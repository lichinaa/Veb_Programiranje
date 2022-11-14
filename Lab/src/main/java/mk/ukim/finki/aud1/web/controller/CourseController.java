package mk.ukim.finki.aud1.web.controller;

import mk.ukim.finki.aud1.Model.Course;
import mk.ukim.finki.aud1.Model.Teacher;
import mk.ukim.finki.aud1.service.CourseService;
import mk.ukim.finki.aud1.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    private final TeacherService teacherService;


    public CourseController(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @GetMapping
    public String getCoursesPage(@RequestParam(required = false) String error, Model model){
        List<Course> courses = this.courseService.listAll();
        model.addAttribute("courses", courses);
        return "/courses";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        this.courseService.deleteById(id);
        return "redirect:/courses";
    }

    @PatchMapping("/add")
    public String saveCourse(@RequestParam String name,
                             @RequestParam String desc,
                             @RequestParam Long teacher,
                             @RequestParam (required = false) Long id){
       this.courseService.save(name, desc, teacher);
       return "redirect:/courses";
    }

    @GetMapping("/add-form")
    public String getAddCoursePage(Model model){
      List<Teacher> teachers = this.teacherService.findAll();
      model.addAttribute("teachers", teachers);
      return "add-course";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditCoursePage(@PathVariable Long id, Model model){
       if(this.courseService.findById(id).isPresent()){
           Course course = this.courseService.findById(id).get();
           List<Teacher> teachers = this.teacherService.findAll();
           model.addAttribute("course", course);
           model.addAttribute("teachers", teachers);

           return "add-course";
       }
       return "redirect:/courses?error=CourseNotFound";
    }



}
