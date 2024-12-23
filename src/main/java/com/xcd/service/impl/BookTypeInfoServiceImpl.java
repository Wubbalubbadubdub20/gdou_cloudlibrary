package com.xcd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcd.common.CustomException;
import com.xcd.common.R;
import com.xcd.mapper.BookTypeInfoMapper;
import com.xcd.pojo.BookTypeInfo;
import com.xcd.pojo.BooksInfo;
import com.xcd.service.BookTypeInfoService;
import com.xcd.service.BooksInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookTypeInfoServiceImpl extends ServiceImpl<BookTypeInfoMapper, BookTypeInfo> implements BookTypeInfoService {

    @Autowired
    private BooksInfoService booksInfoService;

    @Override
    @Transactional
    public R<String> deleteByid(Integer id) {
//        LambdaQueryWrapper<BookTypeInfo> bookTypeInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        bookTypeInfoLambdaQueryWrapper.eq(BookTypeInfo::getTid,id);
//        boolean b = this.removeById(bookTypeInfoLambdaQueryWrapper);
        BookTypeInfo bookTypeInfo = this.getById(id);
        String name = bookTypeInfo.getName();


        LambdaQueryWrapper<BooksInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(BooksInfo::getType, name);
        List<BooksInfo> list = booksInfoService.list(lambdaQueryWrapper);
        if (list.size() > 0) {
            throw new CustomException(name + "分类下还有书籍，无法删除。。");
        }

        this.removeById(id);
        return R.success("删除成功");
    }

    @Override
    @Transactional
    public void removeArray(Long[] tids) {
        for (Long tid : tids) {

            BookTypeInfo bookTypeInfo = this.getById(tid);
            String name = bookTypeInfo.getName();


            LambdaQueryWrapper<BooksInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(BooksInfo::getType, name);
            List<BooksInfo> list = booksInfoService.list(lambdaQueryWrapper);
            if (list.size() > 0) {
                throw new CustomException(name + "分类下还有书籍，无法删除。。");
            }
            this.removeById(tid);
        }
    }


    @Transactional
    @Override
    public void putWithBook(BookTypeInfo classData) {
        Integer tid = classData.getTid();

        BookTypeInfo byId = this.getById(tid);

        String hisName = byId.getName();


        String newName = classData.getName();

        LambdaQueryWrapper<BooksInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(BooksInfo::getType, hisName);


        List<BooksInfo> list = booksInfoService.list(lambdaQueryWrapper);
        for (BooksInfo booksInfo : list) {
            booksInfo.setType(newName);
            booksInfoService.updateById(booksInfo);
        }

        this.updateById(classData);
    }
}
