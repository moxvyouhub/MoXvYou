package com.myapp.moxvyou.Entitys;

import org.litepal.crud.DataSupport;

/**
 * @fileName Book
 * @date on 2020/2/18 16:36
 * author  mo xv you
 */
public class Book  extends DataSupport {
    private int id;
    private String name;
    private String author;
    private int page;
    private double price;

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    private String press;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
