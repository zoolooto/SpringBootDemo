package com.example.springbootdemo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.Service.BookService;
import com.example.springbootdemo.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @Value("${fileLocation}")
    String fileLocation;
    @RequestMapping(method = RequestMethod.POST, value = "addbook/dandan")
    @ResponseBody
    public String addBook(String keywords,HttpSession session) {
        Set<Books> books = bookService.AddBookDanDan(keywords,session);
        String json = JSON.toJSONString(books, true);
        return json;
    }
    @RequestMapping("dandan/success")
    public String addBookByDanDan(HttpSession session){
        Set<Books> dandanBooks = (Set)session.getAttribute("dandanBooks");
        for (Books book:dandanBooks) {
            bookService.addBookBydandan(book);
        }
        return "redirect:/books";
    }
    @RequestMapping("delete/book")
    public String deleteBook(int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping("addbook")
    public String addBook() {

        return "addbook";
    }

    @RequestMapping(value = "addbook", method = RequestMethod.POST)
    public String addBook(String bookname,
                          String author,
                          String press,
                          String price,
                          String introdece,
                          MultipartFile file
    ) throws IOException {
        Date date = new Date();
        String filename = date.getTime() + file.getOriginalFilename();
        String fileDirPath = new String("src/main/resources/" + fileLocation);
        File fileDir = new File(fileDirPath);
        if (!fileDir.exists()) {
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        File newFile = new File(fileDir.getAbsolutePath() + File.separator + filename);
        file.transferTo(newFile);
        Books books=new Books(bookname,author,press,price,introdece,"files/"+filename);
        bookService.addBook(books);
        return "redirect:/books";
    }


}
