package com.futurex.course.CourseApp.Controller;


import com.futurex.course.CourseApp.Domain.User;
import com.futurex.course.CourseApp.Repo.UserRepository;
import com.futurex.course.CourseApp.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;


    @RequestMapping(method = RequestMethod.POST, path = "/saveuser")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        try {
            userService.save(user);
        } catch (Exception e){
            log.error("Exception :",e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/updateuser/{idUser}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long idUser){
        try {
            User olduser = userService.findOne(idUser);
            User newuser = user.toUser();
            olduser.setFirstName(newuser.getFirstName());
            olduser.setLastName(newuser.getLastName());
            olduser.setImageUrl(newuser.getImageUrl());
            olduser.setEmail(newuser.getEmail());
            olduser.setUsername(newuser.getUsername());
            olduser.setPassword(newuser.getPassword());
            olduser.setPermissions(newuser.getPermissions());
            olduser.setRoles(newuser.getRoles());
        } catch (Exception e){
            log.error("Exception :",e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @RequestMapping(method = RequestMethod.GET, path = "/finduser/{idUser}")
    public ResponseEntity<?> findUser(@PathVariable Long idUser){
        try {
           User user = userService.findOne(idUser);
           return ResponseEntity.ok(user);
        } catch (Exception e){
            log.error("Exception :",e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/findallusers")
    public ResponseEntity<?> findAllUsers(){
        try {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e){
            log.error("Exception :",e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/findusername/{userName}")
    public ResponseEntity<?> findUserByName(@PathVariable String userName ){
        try {
          User user = userService.findUserByName(userName);
            return ResponseEntity.ok(user);
        } catch (Exception e){
            log.error("Exception :",e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/deleteuser/{ids}")
    public ResponseEntity<Void> deleteUser(@PathVariable String ids ){
        try {
            String [] idsuser = ids.split(",");
            for (String id : ids.split(","))
            userService.delete(Long.parseLong(id));
        } catch (Exception e){
            log.error("Exception :",e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
