package com.futurex.course.CourseApp.Service;

import com.futurex.course.CourseApp.Domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

     User save (User user);
     void delete (Long id);
     List<User> getAllUsers();
     User findUserByName(String name);
     User findOne(Long id);


}
