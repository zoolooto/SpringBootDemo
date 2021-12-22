package com.example.springbootdemo.Service;

import com.example.springbootdemo.entity.Books;
import com.example.springbootdemo.entity.User;

import java.util.List;

public interface IndexService {
    public User selectById(int id);
    public List<User> selectAll();
    public List<Books> selectAllBooks();
}
