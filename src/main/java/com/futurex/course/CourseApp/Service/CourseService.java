package com.futurex.course.CourseApp.Service;

import com.futurex.course.CourseApp.Model.Course;

import java.util.Optional;

public interface CourseService {

    Optional<Course> findone(Long id);

    Course findCourseByAthor(String author);
}
