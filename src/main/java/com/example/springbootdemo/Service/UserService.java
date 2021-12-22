package com.example.springbootdemo.Service;

import com.example.springbootdemo.entity.User;

import java.util.List;

public interface UserService {
    public boolean addUser(User user);
    public boolean deleteUser(int id);
    public List<User> selectAll();
    public User selectById(int id);
    public boolean updateUser(User user);
}
