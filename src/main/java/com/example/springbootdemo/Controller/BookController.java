package com.example.springbootdemo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.Service.BookService;
import com.example.springbootdemo.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @RequestMapping(method = RequestMethod.POST,value = "/addbook/dandan")
    @ResponseBody
    public String addBook(String keywords){
     Set<Books> books =  bookService.AddBookDanDan(keywords);
     String json = JSON.toJSONString(books, true);
     return json;
    }
    @RequestMapping("delete/book")
    public String deleteBook(int id){
        bookService.deleteBook(id);
        return "books";
    }


}
