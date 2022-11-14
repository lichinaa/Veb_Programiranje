package mk.ukim.finki.aud1.web.servlet;


import mk.ukim.finki.aud1.Model.Course;
import mk.ukim.finki.aud1.service.CourseService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "courses-list-servlet", urlPatterns = "/listCourses")
public class CoursesListServlet extends HttpServlet{

    private final SpringTemplateEngine springTemplateEngine;
    private final CourseService courseService;

    public CoursesListServlet(SpringTemplateEngine springTemplateEngine, CourseService courseService) {
        this.springTemplateEngine = springTemplateEngine;
        this.courseService = courseService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context= new WebContext(req, resp, req.getServletContext());
        context.setVariable("courses", this.courseService.listAll());
        this.springTemplateEngine.process("courses.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // String courseId = (String) req.getParameter("courseId");
        String courseName = (String) req.getParameter("name");
        String courseDesc = (String) req.getParameter("description");
        Course course = new Course(courseName, courseDesc);
      //  courseService.create(course);
        req.getSession().setAttribute("name", course);
        resp.sendRedirect("/listCourses");
    }
}
