package com.xcd.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xcd.common.R;
import com.xcd.pojo.AdminInfo;
import com.xcd.service.AdminInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminInfoController {

    @Autowired
    private AdminInfoService adminInfoService;

    @PostMapping("/login")
    public R<AdminInfo> login(@RequestBody AdminInfo adminInfo, HttpServletRequest httpServletRequest) {
        String operatorPass = adminInfo.getOperatorPass();
        operatorPass = DigestUtils.md5DigestAsHex(operatorPass.getBytes());

        String operatorName = adminInfo.getOperatorName();
        LambdaQueryWrapper<AdminInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper.eq(AdminInfo::getOperatorName,operatorName);
        lambdaQueryWrapper.eq(AdminInfo::getOperatorPass,operatorPass);

        AdminInfo serviceOne = adminInfoService.getOne(lambdaQueryWrapper);
        if (serviceOne != null){
            httpServletRequest.getSession().setAttribute("root",serviceOne.getOperatorName());
            return  R.success(serviceOne);
        }
        return R.error("账号或密码错误");

    }
    @PostMapping("/edit")
    public  R<String> edit(@RequestBody AdminInfo adminInfo){
        adminInfoService.updateById(adminInfo);
        return  R.success("修改成功");
    }

    @GetMapping("/logout")
    public R<String> logout(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().removeAttribute("root");
        return R.success("退出登录");
    }

}
