package com.example.demo.intity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course
{
    private String name;
    @Id
    private int id;

   public Course()
    {

    }

    public Course(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
