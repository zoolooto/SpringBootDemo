
import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.entity.NewBean;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class DemoAJAX {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = in.next();
        String url = "http://search.dangdang.com/?key=" + name + ".html";
        Set<NewBean> books = new HashSet<>();
        // com.example.springbootdemo.entity.NewBean newbean;
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
                    bookdetail =element.getElementsByClass("detail").first().text();
                    bookauthor=element.getElementsByClass("search_book_author").first().child(0).text();
                    searchbook=element.getElementsByClass("search_book_author").first().child(2).text();
                } else {
                    bookurl = element.getElementsByClass("pic").first().
                            getElementsByTag("img").first().attr("data-original");
                    booktitle = element.getElementsByClass("pic").first().attr("title");
                    bookprice = element.getElementsByClass("price").first().child(0).text();
                    bookdetail = element.getElementsByClass("detail").first().text();
                    bookauthor = element.getElementsByClass("search_book_author").first().child(0).text();
                    searchbook = element.getElementsByClass("search_book_author").first().child(2).text();
                }
                // // ???????????????????????????static????????????new
               NewBean newBean=new NewBean(booktitle,bookurl,bookprice,bookauthor,bookdetail,searchbook);
                books.add(newBean);
            }
            for (NewBean bean:books) {
                System.out.println(bean);

            }
            // ??????????????????fastJson?????????json??????????????????true????????????
            String json = JSON.toJSONString(books, true);

        } catch (IOException e) {
            // e.printStackTrace();
            return ;
        }
    }
}

