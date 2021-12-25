package com.example.springbootdemo.Controller;

import com.example.springbootdemo.Service.Impl.PageLogServiceImpl;
import com.example.springbootdemo.entity.Pagelog;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.utils.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ConservatorIndexController {
    @Autowired
    PageLogServiceImpl pageLogServiceImpl;
    @RequestMapping("/ConservatorIndex")
    @PassToken
    public String getConservator(Model model, HttpSession session) {
            User user = (User) session.getAttribute("user");
            if(pageLogServiceImpl.selectPageByName(user.getName())!=null)
            {
                pageLogServiceImpl.updatePage(user.getName());
            }
            else{
                pageLogServiceImpl.insertPage(new Pagelog(user.getName(),1,"0"));
            }
            model.addAttribute("data", pageLogServiceImpl.selcertPage());
            return "ConservatorIndex";
    }

}
