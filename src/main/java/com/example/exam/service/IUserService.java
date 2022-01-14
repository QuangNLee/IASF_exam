package com.example.exam.service;

import com.example.exam.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User save(User user);

    List<User> findAll();

    Optional<User> findById(int id);

    User update(User user);

    boolean delete(User user);
}
