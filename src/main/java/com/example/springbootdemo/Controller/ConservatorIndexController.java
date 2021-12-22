package com.example.springbootdemo.Controller;

import com.example.springbootdemo.Service.Impl.PageLogServiceImpl;
import com.example.springbootdemo.utils.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConservatorIndexController {
    @Autowired
    PageLogServiceImpl pageLogServiceImpl;
    @RequestMapping("/ConservatorIndex")
    @PassToken
    public String getConservator(Model model) {
            model.addAttribute("data", pageLogServiceImpl.selcertPage());
            return "ConservatorIndex";
    }

}
