package com.xcd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcd.mapper.BookHisInfoMapper;
import com.xcd.pojo.BookHisInfo;
import com.xcd.service.BookHisInfoService;
import org.springframework.stereotype.Service;

@Service
public class BookHisInfoServiceImpl extends ServiceImpl<BookHisInfoMapper, BookHisInfo> implements BookHisInfoService {
}
