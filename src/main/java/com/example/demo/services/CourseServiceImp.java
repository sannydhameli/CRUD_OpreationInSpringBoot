package com.example.demo.services;

import com.example.demo.dao.CourseDao;
import com.example.demo.intity.Course;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService
{
    ArrayList<Course> al;

    @Autowired
    public CourseDao courseDao;



    public CourseServiceImp()
        {
            al = new ArrayList<>();
            al.add(new Course("math",101));
            al.add(new Course("bio",202));
        }

    @Override
    public ArrayList<Course> getCourses()
    {


          return (ArrayList<Course>) courseDao.findAllCourse1();
           // return this.al;
    }

    @Override
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Course getCourses(int id)
    {
        Course tem=new Course();
        Course c = (Course)courseDao.getReferenceById(id);
        System.out.println(c);

        tem.setName(c.getName());
        tem.setId(c.getId());

        //return courseDao.findById(id);
               return (Course) courseDao.findByName(c.getName());


    }

    @Override
    public Course addCourse(Course c)
    {
        this.courseDao.save(c);
       // al.add(c);
        return c;
    }

    @Override
    public Course updateCourse(Course c)
    {
        Course course =   courseDao.getReferenceById(c.getId());

            course.setName(c.getName());
            course.setId(c.getId());


        courseDao.save(course);
        return  c;
    }

    @Override
    public void deleteCourse(int c)
    {
            Course entity = courseDao.getReferenceById(c);
            courseDao.delete(entity);

    }

    @Override
    public Course getCoursesbyname(String name) {
        return  courseDao.findByName(name);

    }
}
