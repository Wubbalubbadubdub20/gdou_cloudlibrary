package com.xcd.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class BookTypeInfo implements Serializable {
    @TableId
    private Integer tid;
    @TableField("name")
    private String name;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "BookTypeInfo{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                '}';
    }
}