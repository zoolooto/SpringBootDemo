package com.example.springbootdemo.Service.Impl;

import com.example.springbootdemo.Dao.UserMapper;
import com.example.springbootdemo.Service.UserService;
import com.example.springbootdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public boolean addUser(User user) {
        return userMapper.insert(user)>0;
    }

    @Override
    public boolean deleteUser(int id) {
        return userMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public List<User> selectAll() {

        return userMapper.selectAll();
    }

    @Override
    public User selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateByPrimaryKey(user)>0;
    }
}
