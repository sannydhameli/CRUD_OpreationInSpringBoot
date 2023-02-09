package com.example.demo.services;

import com.example.demo.intity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface CourseService
{
    ArrayList<Course> getCourses();
    Course addCourse(Course c);
    Course getCourses(int id);



    Course updateCourse(Course c);

    void deleteCourse(int c);


    Course getCoursesbyname(String name);
}
