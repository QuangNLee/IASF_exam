package com.example.exam.controller;

import com.example.exam.entity.User;
import com.example.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    //create a new user
    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user){
        userService.save(user);
        return user;
    }

    //get full List User
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getList(){
        return userService.findAll();
    }

    //get detail user
    @RequestMapping(method = RequestMethod.GET, path = "detail/{id}")
    public User getDetail(@PathVariable int id){
        return userService.findById(id).orElse(null);
    }

    //update a User
    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public User update(@PathVariable int id, @RequestBody User updateUser){
        User user = userService.findById(id).orElse(null);
        if(user != null){
            user.setName(updateUser.getName());
            user.setAge(updateUser.getAge());
            user.setSalary(updateUser.getSalary());
            userService.save(user);
        }
        return user;
    }

    //delete a user
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public boolean delete(@PathVariable int id){
        User user = userService.findById(id).orElse(null);
        if(user != null){
            userService.delete(user);
        }
        return false;
    }
}
