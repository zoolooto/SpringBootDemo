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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    @Value("${fileLocation}")
    String fileLocation;
    @Autowired
    BooksMapper booksMapper;
    @Override
    public Set<Books> AddBookDanDan(String bookname, HttpSession session) {
        String url = "http://search.dangdang.com/?key=" + bookname + "&act=input";
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
                    if(booktitle.length()>10)
                    booktitle = booktitle.substring(0, 10);
                    bookprice = element.getElementsByClass("price").first().child(0).text();
                    bookdetail = element.getElementsByClass("detail").first().text();
                    bookauthor = element.getElementsByClass("search_book_author").first().child(0).text();
                    searchbook = element.getElementsByClass("search_book_author").first().child(2).text();
                }
                // // 这里把内部类修饰为static所以直接new
                if(bookdetail.length()>15) {
                    bookdetail = bookdetail.substring(0, 15);
                }
                Books book = new Books(booktitle, bookauthor,searchbook,bookprice, bookdetail,bookurl );
                if(books.size()<20)
                {
                    books.add(book);
                }
                else{
                    break;
                }
            }
            // 使用了阿里的fastJson，其它json框架也可以，true是格式化
            session.setAttribute("dandanBooks",books);
            return books;
        } catch (IOException e) {
            // e.printStackTrace();
            return null;
        }
    }


    @Override
    public boolean addBook(Books books) {
        return booksMapper.insert(books)>0;
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
    @Override
    public boolean addBookBydandan(Books books) {
        URL url=null;
        String pictureUrl="http:"+books.getPicture();
        String picturename=pictureUrl.substring(pictureUrl.lastIndexOf("/"),pictureUrl.length());
        try {
            url=new URL(pictureUrl);
            String fileDirPath = new String("src/main/resources/" + fileLocation+"/imgbook"+picturename);
            String pictureURLS="files/"+"imgbook"+picturename;
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileDirPath));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
            books.setPicture(pictureURLS);
            return booksMapper.insert(books)>0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
