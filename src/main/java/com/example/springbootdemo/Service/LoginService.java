package com.example.springbootdemo.Service;


import com.example.springbootdemo.Dao.UserMapper;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;
    public String login(User user) {
        String token = "";
        User loginUser = userMapper.getUserByUsernameAndPassword(user);
        if(loginUser != null) {
            // 生成token
            token = JwtUtils.createToken(loginUser.getId(), loginUser.getName(), loginUser.getPassword());
        }
        return token;
    }
}
