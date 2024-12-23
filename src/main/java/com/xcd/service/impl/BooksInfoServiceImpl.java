package com.xcd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcd.common.CustomException;
import com.xcd.mapper.BooksInfoMapper;
import com.xcd.pojo.BooksInfo;
import com.xcd.service.BooksInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BooksInfoServiceImpl extends ServiceImpl<BooksInfoMapper, BooksInfo>  implements BooksInfoService {

    @Override
    @Transactional
    public void removeArray(Long[] bids) {
        for (Long id : bids) {
            BooksInfo booksInfo = this.getById(id);
            Integer status = booksInfo.getStatus();
            if (status != 2){
                throw  new CustomException("该图书:{ "+booksInfo.getName()+" }正在借阅，无法删除");
            }

            this.removeById(id);
        }
    }
}
