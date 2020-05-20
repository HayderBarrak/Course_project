package com.futurex.course.CourseApp.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long courseid;
    private String coursename;
    private String author;

    public Course tocourse() {
        Course course = new Course();
        course.setAuthor(author);
        course.setCoursename(coursename);
        return course;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
