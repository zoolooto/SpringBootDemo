package com.example.springbootdemo.Controller;

import com.example.springbootdemo.Service.LoginService;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.utils.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class ProjectController {
    @Autowired
    private LoginService loginservice;
    @GetMapping
    public String login(Model model){
        return "login";
    }
    @PostMapping
    @PassToken
    public String login(User user) {
        return loginservice.login(user);
    }
}
