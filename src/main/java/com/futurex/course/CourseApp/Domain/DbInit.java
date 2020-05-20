package com.futurex.course.CourseApp.Domain;

import com.futurex.course.CourseApp.Repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Crete users
        User simpleUser = new User("hayder",passwordEncoder.encode("hayder"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("admin"),"ADMIN","ACCESS_TEST1");
        List<User> users = Arrays.asList(simpleUser,admin);

        // Save to db
        this.userRepository.saveAll(users);
    }
}
