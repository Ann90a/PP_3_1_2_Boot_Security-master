package ru.kata.spring.boot_security.demo.services;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    public void save(User user);

    public User findByUsername (String username);

    public List<User> getAllUsers();

    public void deleteById(Long id);

    public User getById(long id);

}

