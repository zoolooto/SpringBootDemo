package com.project.Controller;

import com.project.Service.LoginService;
import com.project.entity.User;
import com.project.utils.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class ProjectController {
    @Autowired
    private LoginService loginService;
    @PostMapping
    @PassToken
    public String login(User user) {
        return loginService.login(user);
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }
}
