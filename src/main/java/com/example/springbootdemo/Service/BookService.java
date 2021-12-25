package com.example.springbootdemo.Service;

import com.example.springbootdemo.entity.Books;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

public interface BookService {
        public Set<Books> AddBookDanDan(String bookName, HttpSession session);
        public boolean addBook(Books books);
        public boolean updateBook();
        public boolean deleteBook(int id);
        public Books insertBook();
        public Books selectBook();
        public List<Books> selectAll();
        public boolean addBookBydandan(Books books);
}
