package com.example.springbootdemo.Service;

import com.example.springbootdemo.entity.Books;

import java.util.List;
import java.util.Set;

public interface BookService {
        public Set<Books> AddBookDanDan(String bookName);
        public boolean addBook();
        public boolean updateBook();
        public boolean deleteBook(int id);
        public Books insertBook();
        public Books selectBook();
        public List<Books> selectAll();
}
