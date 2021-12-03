package com.project.Service;


import com.project.Dao.UserMapper;
import com.project.entity.User;
import com.project.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;

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
