package com.example.springbootdemo.Service.Impl;

import com.example.springbootdemo.Dao.BooksMapper;
import com.example.springbootdemo.Dao.UserMapper;
import com.example.springbootdemo.Service.IndexService;
import com.example.springbootdemo.entity.Books;
import com.example.springbootdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    BooksMapper booksMapper;
    @Override
    public User selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectAll() {
       return userMapper.selectAll();
    }

    @Override
    public List<Books> selectAllBooks() {
     return booksMapper.selectAll();
    }
}
