package com.example.springbootdemo.entity;

import java.io.Serializable;

public class Books implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.BookName
     *
     * @mbggenerated
     */
    private String bookname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.author
     *
     * @mbggenerated
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.press
     *
     * @mbggenerated
     */
    private String press;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.price
     *
     * @mbggenerated
     */
    private String price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.introduce
     *
     * @mbggenerated
     */
    private String introduce;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column books.picture
     *
     * @mbggenerated
     */
    private String picture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table books
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.ID
     *
     * @return the value of books.ID
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.ID
     *
     * @param id the value for books.ID
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.BookName
     *
     * @return the value of books.BookName
     *
     * @mbggenerated
     */
    public String getBookname() {
        return bookname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.BookName
     *
     * @param bookname the value for books.BookName
     *
     * @mbggenerated
     */
    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.author
     *
     * @return the value of books.author
     *
     * @mbggenerated
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.author
     *
     * @param author the value for books.author
     *
     * @mbggenerated
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.press
     *
     * @return the value of books.press
     *
     * @mbggenerated
     */
    public String getPress() {
        return press;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.press
     *
     * @param press the value for books.press
     *
     * @mbggenerated
     */
    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.price
     *
     * @return the value of books.price
     *
     * @mbggenerated
     */
    public String getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.price
     *
     * @param price the value for books.price
     *
     * @mbggenerated
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.introduce
     *
     * @return the value of books.introduce
     *
     * @mbggenerated
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.introduce
     *
     * @param introduce the value for books.introduce
     *
     * @mbggenerated
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column books.picture
     *
     * @return the value of books.picture
     *
     * @mbggenerated
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column books.picture
     *
     * @param picture the value for books.picture
     *
     * @mbggenerated
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table books
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bookname=").append(bookname);
        sb.append(", author=").append(author);
        sb.append(", press=").append(press);
        sb.append(", price=").append(price);
        sb.append(", introduce=").append(introduce);
        sb.append(", picture=").append(picture);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Books(Integer id, String bookname, String author, String press, String price, String introduce, String picture) {
        this.id = id;
        this.bookname = bookname;
        this.author = author;
        this.press = press;
        this.price = price;
        this.introduce = introduce;
        this.picture = picture;
    }

    public Books(String bookname, String author, String price, String introduce, String picture) {
        this.bookname = bookname;
        this.author = author;
        this.price = price;
        this.introduce = introduce;
        this.picture = picture;
    }

    public Books() {
    }
}