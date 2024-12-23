package com.xcd.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 自定义全局异常处理器
 */
@Slf4j
@ControllerAdvice(annotations = {RestController.class, Controller.class, Service.class})
@ResponseBody
public class GlobalExceptionHandler {
    /**
     *
     * @param ext 需要处理的异常类型
     * @return 返回业务消息
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String>  exceptionHandler(SQLIntegrityConstraintViolationException ext){
//        log.error(ext.getMessage());
//        if (ext.getMessage().contains("Duplicate entry")){
//            String[] s = ext.getMessage().split(" ");
//            return R.error("账号:"+s[2]+"已存在");
//
//        }
        if (ext.getMessage().contains("for key 'book_type_info.book_type_info_pk'")){
            String[] s = ext.getMessage().split(" ");
//            System.out.println(ext.toString());
            log.info("ext= {}",ext.toString());
            return R.error(s[2]+"已存在");

        }
        return R.error("未知错误");
    }

    @ExceptionHandler(CustomException.class)
    public R<String>  MyexceptionHandler(CustomException ext){

        return R.error(ext.getMessage());
    }
}
