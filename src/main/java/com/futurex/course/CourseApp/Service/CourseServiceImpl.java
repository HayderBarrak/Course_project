package com.futurex.course.CourseApp.Service;


import com.futurex.course.CourseApp.Model.Course;
import com.futurex.course.CourseApp.Repo.CourseRepository;
import com.futurex.course.CourseApp.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("CourseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;


    @Override
    public Optional<Course> findone(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> findCourseByAthor(String author) {
        return courseRepository.findCourseByAuthor(author);
    }
}
