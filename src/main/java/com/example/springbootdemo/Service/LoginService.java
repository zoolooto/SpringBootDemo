package com.example.springbootdemo.Service;

import com.example.springbootdemo.entity.User;

import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    public User login(User user, HttpServletResponse response);
}
