package com.xcd.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xcd.common.CustomException;
import com.xcd.common.R;
import com.xcd.dto.UserDto;
import com.xcd.pojo.UserInfo;
import com.xcd.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public R<UserInfo> userLogin(@RequestBody UserDto userInfo, HttpServletRequest httpServletRequest) {
        String code = (String) httpServletRequest.getSession().getAttribute("code");
        log.info("user= {}", userInfo);
        if (code.equalsIgnoreCase(userInfo.getCode())) {

            String username = userInfo.getUsername();
            String password = userInfo.getPassword();
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(UserInfo::getUsername, username);
            lambdaQueryWrapper.eq(UserInfo::getPassword, password);
            UserInfo one = userInfoService.getOne(lambdaQueryWrapper);
            if (one != null) {
                if (one.getStatus() == 1){
                    HttpSession session = httpServletRequest.getSession();

                    session.setAttribute("user",one.getUsername());
                    log.info("登录成功存入session {}",session.getAttribute("user").toString());
                    return R.success(one);
                }else {
                    return R.error("账号被锁定，无法登录。请联系管理员！");
                }
            } else {
                return R.error("账号或密码错误");
            }

        } else {
            return R.error("验证码错误");
        }
    }

    @PostMapping("/register")
    public R<String> register(@RequestBody UserInfo user) {
        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(UserInfo::getUsername, user.getUsername());
        UserInfo one = userInfoService.getOne(lambdaQueryWrapper);
        if (one != null) {
            throw new CustomException("用户名已存在,无法注册");
        }

        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(password);

        user.setPassword(password);

        userInfoService.save(user);

        return R.success("注册成功");
    }

    @GetMapping("/checkUsername")
    public R<String> checkUsername(String username) {
        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(UserInfo::getUsername, username);
        UserInfo userInfo = userInfoService.getOne(lambdaQueryWrapper);
        if (userInfo == null) {
            return R.success("用户名可用");
        }
        return R.error("用户名已存在");
    }

    @GetMapping("/page")
    public R<Page<UserInfo>> page(Integer page,Integer pageSize,String name,String username){
        Page<UserInfo> userInfoPage = new Page<>(page,pageSize);

        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper.like(StringUtils.isNotEmpty(name),UserInfo::getName,name);
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(username),UserInfo::getUsername,username);


        userInfoService.page(userInfoPage,lambdaQueryWrapper);


        return R.success(userInfoPage);
    }

    @DeleteMapping
    public R<String> delete(Long[] aids){
        userInfoService.deleteArray(aids);
        return R.success("删除成功");

    }

    @PostMapping("/status")
    public  R<String> updateStatus(@RequestBody UserInfo userInfo){

        userInfoService.updateById(userInfo);
        return  R.success("修改状态成功");
    }

    @PostMapping("/edit")
    public R<String> edit(@RequestBody UserInfo userInfo){
        String password = userInfo.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        userInfo.setPassword(password);
        userInfoService.updateById(userInfo);
        return R.success("修改成功");
    }
    @GetMapping("/logout")
    public R<String> logout(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().removeAttribute("user");
        return R.success("退出登录");
    }
}
