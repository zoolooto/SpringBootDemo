package com.example.springbootdemo.entity;

public class NewBean {
    private String booktitle;
    private String imgUrl;
    private String Bookprice;
    private String Bookauthor;
    private String Bookdetail;
    private String searchBook;
    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getBookprice() {
        return Bookprice;
    }

    public void setBookprice(String bookprice) {
        Bookprice = bookprice;
    }

    public String getBookauthor() {
        return Bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        Bookauthor = bookauthor;
    }

    public String getBookdetail() {
        return Bookdetail;
    }

    public void setBookdetail(String bookdetail) {
        Bookdetail = bookdetail;
    }

    public String getSearchBook() {
        return searchBook;
    }

    public void setSearchBook(String searchBook) {
        this.searchBook = searchBook;
    }

    public NewBean(String booktitle, String imgUrl, String bookprice, String bookauthor, String bookdetail, String searchBook) {
        this.booktitle = booktitle;
        this.imgUrl = imgUrl;
        Bookprice = bookprice;
        Bookauthor = bookauthor;
        Bookdetail = bookdetail;
        this.searchBook = searchBook;
    }
    public NewBean() {
    }

    @Override
    public String toString() {
        return "com.example.springbootdemo.entity.NewBean{" +
                "booktitle='" + booktitle + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", Bookprice='" + Bookprice + '\'' +
                ", Bookauthor='" + Bookauthor + '\'' +
                ", Bookdetail='" + Bookdetail + '\'' +
                ", searchBook='" + searchBook + '\'' +
                '}';
    }
}
