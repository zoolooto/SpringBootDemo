package com.example.springbootdemo.Service.Impl;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.Dao.BooksMapper;
import com.example.springbootdemo.Service.BookService;
import com.example.springbootdemo.entity.Books;
import com.example.springbootdemo.entity.NewBean;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BooksMapper booksMapper;
    @Override
    public Set<Books> AddBookDanDan(String bookname) {
        String url = "http://search.dangdang.com/?key=" + bookname + ".html";
        Set<Books> books = new HashSet<>();
        // NewBean newbean;
        try {
            Connection connect = Jsoup.connect(url);
            Map<String, String> header = new HashMap<String, String>();
            header.put("Host", "http://search.dangdang.com");
            header.put("User-Agent", "  Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0");
            header.put("Accept", "  text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            header.put("Accept-Language", "zh-cn,zh;q=0.5");
            header.put("Accept-Charset", "  GB2312,utf-8;q=0.7,*;q=0.7");
            header.put("Connection", "keep-alive");
            Connection data = connect.headers(header);
            Document doc = data.get();
            Element contents = doc.select("#search_nature_rg").first();
            Elements content = contents.getElementsByClass("bigimg");
            Elements linka = content.first().getElementsByTag("li");
            boolean flag = false;
            for (Element element : linka) {
                String bookurl;
                String booktitle;
                String bookprice;
                String bookdetail;
                String bookauthor;
                String searchbook;
                if (!flag) {
                    bookurl = element.getElementsByClass("pic").first().
                            getElementsByTag("img").first().attr("src");
                    flag = true;
                    booktitle = element.getElementsByClass("pic").first().attr("title");
                    bookprice = element.getElementsByClass("price").first().child(0).text();
                    bookdetail = element.getElementsByClass("detail").first().text();
                    bookauthor = element.getElementsByClass("search_book_author").first().child(0).text();
                    searchbook = element.getElementsByClass("search_book_author").first().child(2).text();
                } else {
                    bookurl = element.getElementsByClass("pic").first().
                            getElementsByTag("img").first().attr("data-original");
                    booktitle = element.getElementsByClass("pic").first().attr("title");
                    booktitle = booktitle.substring(0, 10);
                    bookprice = element.getElementsByClass("price").first().child(0).text();
                    bookdetail = element.getElementsByClass("detail").first().text();
                    bookauthor = element.getElementsByClass("search_book_author").first().child(0).text();
                    searchbook = element.getElementsByClass("search_book_author").first().child(2).text();
                }
                // // 这里把内部类修饰为static所以直接new
                Books book = new Books(booktitle, bookauthor, bookprice, bookdetail,bookurl );
                books.add(book);
            }
            // 使用了阿里的fastJson，其它json框架也可以，true是格式化
            return books;
        } catch (IOException e) {
            // e.printStackTrace();
            return null;
        }
    }


    @Override
    public boolean addBook() {
        return false;
    }

    @Override
    public boolean updateBook() {
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
        return booksMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Books insertBook() {
        return null;
    }

    @Override
    public Books selectBook() {
        return null;
    }

    @Override
    public List<Books> selectAll() {
        return null;
    }
}
