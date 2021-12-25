package com.example.springbootdemo.Controller;
import com.example.springbootdemo.Service.IndexService;
import com.example.springbootdemo.entity.Books;
import com.example.springbootdemo.utils.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;

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
    public String indexPage(Model model){
        Random random =new Random();
        List<Books> booksList = indexService.selectAllBooks();
        Books books= indexService.selectlBooks().get(random.nextInt(indexService.selectlBooks().size()));
        model.addAttribute("HotstyleBook",books);
        model.addAttribute("books",indexService.selectlBooks());
        booksList=booksList.subList(0,3);
        model.addAttribute("preferential",booksList);
        return "index";
    }
    @RequestMapping("Listbooks")
    public String indexListbooks(){
        return  "Listbooks";
    }
}
