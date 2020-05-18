package com.futurex.course.CourseApp.Service;

import com.futurex.course.CourseApp.Model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Optional<Course> findone(Long id);

    List<Course> findCourseByAthor(String author);
}
