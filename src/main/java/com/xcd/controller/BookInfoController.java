package com.xcd.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xcd.common.R;
import com.xcd.pojo.BooksInfo;
import com.xcd.service.BooksInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/book_info")
public class BookInfoController {
   @Autowired
   private BooksInfoService booksInfoService;

    @RequestMapping("/page")
    public R<Page<BooksInfo>> page(Integer page,Integer pageSize,String name,String author,String type,String card,Integer status){
        Page<BooksInfo> booksInfoPage = new Page<>(page,pageSize);
        LambdaQueryWrapper<BooksInfo> booksInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (status != null){

            booksInfoLambdaQueryWrapper.like(StringUtils.isNotEmpty(name),BooksInfo::getName,name);
            booksInfoLambdaQueryWrapper.like(StringUtils.isNotEmpty(author),BooksInfo::getAuthor,author);
            booksInfoLambdaQueryWrapper.like(StringUtils.isNotEmpty(type),BooksInfo::getType,type);
            booksInfoLambdaQueryWrapper.like(StringUtils.isNotEmpty(card),BooksInfo::getCard,card);
            booksInfoLambdaQueryWrapper.eq(BooksInfo::getStatus,status);

        }
        else {

            booksInfoLambdaQueryWrapper.like(StringUtils.isNotEmpty(name),BooksInfo::getName,name);
            booksInfoLambdaQueryWrapper.like(StringUtils.isNotEmpty(author),BooksInfo::getAuthor,author);
            booksInfoLambdaQueryWrapper.like(StringUtils.isNotEmpty(type),BooksInfo::getType,type);
            booksInfoLambdaQueryWrapper.like(StringUtils.isNotEmpty(card),BooksInfo::getCard,card);

        }




        booksInfoService.page(booksInfoPage,booksInfoLambdaQueryWrapper);

        return R.success(booksInfoPage);
    }
    @PostMapping
    public R<String> save(@RequestBody BooksInfo booksInfo){
        booksInfoService.save(booksInfo);
        return R.success("添加成功");

    }
    @DeleteMapping
    public R<String> delete(Long[] bids){
        booksInfoService.removeArray(bids);
        return R.success("删除成功");

    }
    @PutMapping
    public R<String> put(@RequestBody BooksInfo booksInfo){
        booksInfoService.updateById(booksInfo);
        return R.success("修改成功");

    }
}
