package com.xcd.pojo;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class BooksInfo implements Serializable {
    @TableId
    private Integer bid;

    private String name;

    private String card;

    private String author;

    private Integer num;

    private String press;
    //2 未借出 1 借出
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BooksInfo{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", card='" + card + '\'' +
                ", author='" + author + '\'' +
                ", num=" + num +
                ", press='" + press + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    private String type;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}