package com.xcd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcd.mapper.AdminInfoMapper;
import com.xcd.pojo.AdminInfo;
import com.xcd.service.AdminInfoService;
import org.springframework.stereotype.Service;

@Service
public class AdminInfoServiceImpl extends ServiceImpl<AdminInfoMapper, AdminInfo> implements AdminInfoService {
}
