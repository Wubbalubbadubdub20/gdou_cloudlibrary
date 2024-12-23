package com.xcd.pojo;

import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class BookHisInfo {
    @TableId
    private Integer hid;

    private Integer aid;

    private String bid;

    private String card;

    private String bookName;

    private String adminName;

    private String username;

    private Date beginTime;

    private Date endTime;

    private Integer status;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookHisInfo{" +
                "hid=" + hid +
                ", aid=" + aid +
                ", bid='" + bid + '\'' +
                ", card='" + card + '\'' +
                ", bookName='" + bookName + '\'' +
                ", adminName='" + adminName + '\'' +
                ", username='" + username + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status=" + status +
                '}';
    }
}