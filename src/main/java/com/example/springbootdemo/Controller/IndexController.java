package com.example.springbootdemo.Controller;
import com.example.springbootdemo.Service.IndexService;
import com.example.springbootdemo.utils.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
    @Autowired
    IndexService indexService;
    @RequestMapping("/")
    @PassToken
    public String HomePage(){
        return "login";
    }
    @RequestMapping("/profile")
    public String IndexProfile(Model model,int id){
        model.addAttribute("oneself",indexService.selectById(id));
        return "profile";
    }
    @RequestMapping("/users")
    public String IndexUsers(Model model){
        model.addAttribute("users",indexService.selectAll());
        return "users";
    }
    @RequestMapping("/books")
    public String Indexroles(Model model){
        model.addAttribute("books",indexService.selectAllBooks());
        return "books";
    }
    @RequestMapping("/index")
    public String indexPage(){
        return "index";
    }
    // @RequestMapping("/AddUser")
    // public String AddUser(){
    //     return "updateUser";
    // }
}
