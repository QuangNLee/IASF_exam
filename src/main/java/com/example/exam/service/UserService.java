package com.example.exam.service;

import com.example.exam.entity.User;
import com.example.exam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }

    public User update(User user){
        return userRepository.save(user);
    }

    public boolean delete(User user){
        userRepository.delete(user);
        return true;
    }
}
