package com.xcd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcd.mapper.UserInfoMapper;
import com.xcd.pojo.UserInfo;
import com.xcd.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>  implements UserInfoService {

    @Override
    @Transactional
    public void deleteArray(Long[] aids) {
        for (Long aid : aids) {
            this.removeById(aid);
        }
    }
}
