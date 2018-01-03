package com.lanou3g.domain;

public class Book {
    private String uid;
    private String bname;
    private String author;
    private String price;

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "uid='" + uid + '\'' +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
