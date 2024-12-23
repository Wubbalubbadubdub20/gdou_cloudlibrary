package com.xcd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcd.common.R;
import com.xcd.pojo.BookTypeInfo;
import com.xcd.pojo.BooksInfo;

public interface BooksInfoService extends IService<BooksInfo> {
    void removeArray(Long[] ids);
}
