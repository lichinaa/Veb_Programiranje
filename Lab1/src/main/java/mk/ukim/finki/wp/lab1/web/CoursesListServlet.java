package mk.ukim.finki.wp.lab1.web;

import mk.ukim.finki.wp.lab1.model.Course;
import mk.ukim.finki.wp.lab1.model.Student;
import mk.ukim.finki.wp.lab1.service.CourseService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "courses-list-servlet", urlPatterns = "/listCourses")
public class CoursesListServlet extends HttpServlet implements CourseService {

    private final SpringTemplateEngine springTemplateEngine;
    private final CourseService courseService;

    public CoursesListServlet(SpringTemplateEngine springTemplateEngine, CourseService courseService) {
        this.springTemplateEngine = springTemplateEngine;
        this.courseService = courseService;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return null;
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        return null;
    }

    @Override
    public List<Course> listAll() {
        return courseService.listAll();
    }

    @Override
    public Course create(Long id, String name, String desc) {
        return courseService.create(id, name, desc);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     /* List<Course> courses = courseService.listAll();
      PrintWriter writer= resp.getWriter();
        writer.println("<h2>Courses</h2>");
        writer.println("<ul>");
        courses.forEach(r->
                writer.format("<li>%s</li>", r.getName()));
        writer.println("</ul>");
*/
      WebContext context= new WebContext(req, resp, req.getServletContext());
      context.setVariable("courses", this.courseService.listAll());
      this.springTemplateEngine.process("listCourses.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long coursesId = Long.parseLong((String) req.getParameter("courseId"));
        courseService.create(coursesId);
        resp.sendRedirect("/listCourses");
    }
}
