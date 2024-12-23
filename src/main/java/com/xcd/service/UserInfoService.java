package com.xcd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcd.common.R;
import com.xcd.pojo.BookTypeInfo;
import com.xcd.pojo.UserInfo;

public interface UserInfoService extends IService<UserInfo> {

    void deleteArray(Long[] aids);
}
