package com.example.springbootdemo.Service.Impl;


import com.example.springbootdemo.Dao.UserMapper;
import com.example.springbootdemo.Service.LoginService;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    public User login(User user, HttpServletResponse response) {
        String token = "";
        User loginUser = userMapper.getUserByUsernameAndPassword(user);
        if (loginUser != null) {
                // 生成token
                token = JwtUtils.createToken(loginUser.getId(), loginUser.getName());
                Cookie cookie = new Cookie("token", token);
                cookie.setMaxAge(60*10*10);
                response.addCookie(cookie);
                return loginUser;
        } else {
            return null;
        }

    }
}
