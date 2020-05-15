package com.futurex.course.CourseApp.Controller;

import com.futurex.course.CourseApp.Repo.CourseRepository;
import com.futurex.course.CourseApp.Service.CourseServiceImpl;
import com.futurex.course.CourseApp.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

  @Autowired
    private CourseServiceImpl courseService;



    @GetMapping("/all")
    public @ResponseBody List<Course> getCourses() {
        return courseRepository.findAll();
    }

  @GetMapping("/user/{id}")
    public Optional<Course> FindCourse(@PathVariable ("id") Long id) {
        return courseService.findone(id);
    }

     @RequestMapping(method = RequestMethod.GET,
             produces = "application/json",
             value = "/user/author/{author}")
    public Course FindCourseAuthor(@PathVariable String author) {
          return  courseRepository.findCourseByAuthor(author);
    }

  @RequestMapping(method = RequestMethod.GET,
             produces = "application/json",
             value = "/user/courses/{course}")
    public List<Course> FindCourseName(@PathVariable String course) {
          return  courseRepository.findCourseByCoursename(course);
    }

    @PostMapping("/admin/save")
    public void setCourses(@RequestBody Course courses) {
        courseRepository.save(courses);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/admin/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }


//     @RequestMapping(method = RequestMethod.GET,
//             produces = "application/json",
//             value = "/courses2/{course}")
//    public List<Course> FindCourseName2(@PathVariable String course) {
//          return  courseRepository.findCoursename(course);
//    }

//     @RequestMapping(method = RequestMethod.GET,
//             produces = "application/json",
//             value = "/courses")
//    public List<Course> FindCourses() {
//          return  courseRepository.findAllCourses();
//    }

    //     @GetMapping("/all/{id}")
//    public Course getCourses(@PathVariable ("id") Long id) {
//        return courseRepository.getOne(id);
//    }



}
