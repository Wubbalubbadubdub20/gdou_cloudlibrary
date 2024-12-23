package com.xcd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcd.common.R;
import com.xcd.pojo.BookTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;

public interface BookTypeInfoService extends IService<BookTypeInfo> {
    R<String> deleteByid(Integer id);

    void removeArray(Long[] tids);

    void putWithBook(BookTypeInfo classData);
}
