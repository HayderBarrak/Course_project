package com.futurex.course.CourseApp.Controller;

import com.futurex.course.CourseApp.Repo.CourseRepository;
import com.futurex.course.CourseApp.Service.CourseServiceImpl;
import com.futurex.course.CourseApp.Domain.Course;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class CourseController {

    private final Logger log = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseServiceImpl courseService;



    @PostMapping("/save/course")
    public ResponseEntity<Void> setCourses(@RequestBody Course courses) {
        try {
            courseRepository.save(courses);
        } catch (Exception e){
            log.error("Exception : {}" , e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
            return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/updatecourse/{id}")
    public ResponseEntity<?> UpdateCourse(@RequestBody Course course ,@PathVariable Long id) {
        try {
            Course oldCouse = courseRepository.getOne(id);
            Course newCourse = course.tocourse();
            oldCouse.setAuthor(newCourse.getAuthor());
            oldCouse.setCoursename(newCourse.getCoursename());
            courseRepository.save(oldCouse);
        } catch (Exception e) {
            log.error("Exception : {}" , e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("The course successfully updated" ,HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<?> getCourses() {
        List<Course> courses ;
        try {
            courses  = courseRepository.findAll();
            return ResponseEntity.ok(courses);
        } catch (Exception e) {
            log.error("Exception : {}" , e.getMessage());
            return new ResponseEntity<>("Exception :" +e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

  @GetMapping("/course/{id}")
    public ResponseEntity<?> FindCourse(@PathVariable ("id") Long id) {
        try {
            Optional<Course> course = courseService.findone(id);
            return ResponseEntity.ok(course);
        } catch (Exception e){
            log.error("Exception : {}" , e.getMessage());
            return new ResponseEntity<>("Exception :" +e.getMessage() ,HttpStatus.BAD_REQUEST);
        }
    }

     @RequestMapping(method = RequestMethod.GET,
             produces = "application/json",
             value = "/courseauthor/{author}")
    public ResponseEntity<?> FindCourseAuthor(@PathVariable String author) {
         try {
        List<Course> courselst = courseService.findCourseByAthor(author);
          return  ResponseEntity.ok(courselst);
         } catch (Exception e){
             log.error("Exception : {}" , e.getMessage());
             return new ResponseEntity<>("Exception :" +e.getMessage() ,HttpStatus.BAD_REQUEST);
         }
    }

  @RequestMapping(method = RequestMethod.GET,
             produces = "application/json",
             value = "/coursename/{course}")
    public ResponseEntity<?> FindCourseName(@PathVariable String course) {
      try {
      List<Course> courselst = courseRepository.findCourseByCoursename(course);;
          return  ResponseEntity.ok(courselst);
      } catch (Exception e){
          log.error("Exception : {}" , e.getMessage());
          return new ResponseEntity<>("Exception :" +e.getMessage() ,HttpStatus.BAD_REQUEST);
      }
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{ids}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String ids) {
        try {
            String str [] = ids.split(",");
            for (String id : ids.split(","))
            courseRepository.deleteById(Long.parseLong(id));
        } catch (Exception e){
            log.error("Exception : {}" , e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
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
