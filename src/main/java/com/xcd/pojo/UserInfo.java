package com.xcd.pojo;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class UserInfo implements Serializable {
    @TableId
    private Integer aid;

    private String username;

    private String name;

    private String password;

    private String email;

    private String phone;

    private Integer status;

    private Integer lendNum;

    private Integer maxNum;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLendNum() {
        return lendNum;
    }

    public void setLendNum(Integer lendNum) {
        this.lendNum = lendNum;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "aid=" + aid +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", lendNum=" + lendNum +
                ", maxNum=" + maxNum +
                '}';
    }
}