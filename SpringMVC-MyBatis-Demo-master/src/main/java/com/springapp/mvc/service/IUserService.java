package com.springapp.mvc.service;

import com.springapp.mvc.model.User;

import java.util.List;

public interface IUserService {
    public List<User> getAllUsers();

    public User getUser(long userId);

    public void addUser(User user);

    public void deleteUser(long userId);
}
