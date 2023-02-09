package com.example.demo.Controller;

import com.example.demo.intity.Course;
import com.example.demo.services.CourseService;
import com.example.demo.services.CourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MyController
{

   @Autowired
    private CourseService courseservice;
           // new CourseServiceImp();
    @GetMapping(path = "/")
    public String home()
    {
        return "Home";
    }

    @GetMapping(path = "/course")
    public ArrayList<Course> getCourse()
    {
         return this.courseservice.getCourses();
    }

    @GetMapping(path = "/course/{courseId}")
    public Course getCourse(@PathVariable String courseId)
    {
         return this.courseservice.getCourses(Integer.parseInt(courseId));
    }

    @PostMapping(path = "/course/{name}")
    public Course getCoursesByName(@PathVariable String name)
    {
        return this.courseservice.getCoursesbyname(name);
    }

    @PostMapping(path = "/course")
    public Course addCourse(@RequestBody Course c)
    {
        System.out.println("this is addCourse");
        this.courseservice.addCourse(c);
        return c;
    }

    @PutMapping(path = "/course")
    public Course updateCourse(@RequestBody Course c)
    {
        return this.courseservice.updateCourse(c);
    }

    @DeleteMapping(path = "/course/{courseid}")
    public void deleteCourse(@PathVariable String courseid)
    {
         this.courseservice.deleteCourse(Integer.parseInt(courseid));
    }


}
