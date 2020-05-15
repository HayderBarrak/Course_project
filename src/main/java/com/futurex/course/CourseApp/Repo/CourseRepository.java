package com.futurex.course.CourseApp.Repo;

import com.futurex.course.CourseApp.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findCourseByAuthor(String author);

    List<Course> findCourseByCoursename(String courseName);

    @Query("select c from Course c where c.coursename= ?1")
    List<Course> findCoursename(String courseName);


    @Query(value = "select * from course" , nativeQuery = true)
    List<Course> findAllCourses();

}
