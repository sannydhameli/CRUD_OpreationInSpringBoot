package com.example.demo.dao;

import com.example.demo.intity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public interface CourseDao extends JpaRepository<Course, Integer>
{
     public Course findByName(String iName);


     @Query(value = "select * from course",nativeQuery = true)
     //@Query("select u from course u")---> error
     public List<Course> findAllCourse1();



}
