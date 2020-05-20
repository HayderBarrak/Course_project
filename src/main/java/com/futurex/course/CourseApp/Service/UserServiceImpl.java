package com.futurex.course.CourseApp.Service;


import com.futurex.course.CourseApp.Domain.User;
import com.futurex.course.CourseApp.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public User save(User user) {
      return  userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public User findOne(Long id) {
        return userRepository.getOne(id);
    }
}
