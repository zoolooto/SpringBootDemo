package com.example.springbootdemo.Controller;

import com.example.springbootdemo.Service.UserService;
import com.example.springbootdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("delete/user")
    public String delete(int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @RequestMapping("update/user")
    public String updateUserByid(Model model, int id) {
        User userId = userService.selectById(id);
        model.addAttribute("userId", userId);
        return "updateUser";
    }

    @RequestMapping(value = "/adduser")
    public String addUser() {
        return "adduser";
    }

    @Value("${fileLocation}")
    String fileLocation;

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String  addUser(String name,
                          String password,
                          String PaymentPassword,
                          MultipartFile file,
                          double Balance,
                          int grade
    ) throws IOException {
        String realPath= ResourceUtils.getURL("classpath:").getPath()+fileLocation;
        File newFile =new File(realPath);
        Date date=new Date();
        if (!newFile.exists()) newFile.mkdirs();
        // 上传
        String fileName = date.getTime() +"@" + file.getOriginalFilename();
        file.transferTo(new File(newFile, fileName));
        User user=new User(name,password,PaymentPassword,fileName,Balance,grade);

        userService.addUser(user);

        return "redirect:/users";
    }
}
