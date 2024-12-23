package com.xcd.dto;

import com.xcd.pojo.UserInfo;
import lombok.Data;

@Data
public class UserDto extends UserInfo {
    private String code;

    @Override
    public String toString() {
        return "UserDto{" +
                "code='" + code + '\'' +
               "username=" +super.getUsername()+ '}';
    }
}
