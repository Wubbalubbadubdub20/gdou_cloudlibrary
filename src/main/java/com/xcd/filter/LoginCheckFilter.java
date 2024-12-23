package com.xcd.filter;

import com.alibaba.fastjson.JSON;
import com.xcd.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //路径匹配器
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

//        过滤器具体的处理逻辑如下:
//        1、获取本次请求的URI
//        2、判断本次请求是否需要处理
//        3、如果不需要处理,则直接放行
//        4、判断登录状态,如果已登录,则直接放行
//        5、如果未登录则返回未登录结果
        String requestURI = request.getRequestURI();
        log.info("拦截到路径：{}", requestURI);
        String[] urls = {"/admin/login","/user/login",
               "/html/common/login.html","/html/admin/login.html","/html/common/register.html",
                "/element-ui/**", "/images/**","/js/**","/plugins/**","/styles/**","/user/register","/user/checkUsername",
            "/CodeImageServlet","/user/logout","/admin/logout"};
        boolean flag = check(urls, requestURI);
        if (flag) {
            log.info("本次请求 {} 不需要处理", requestURI);
            filterChain.doFilter(request, response);
            return;
        }

        String username = (String) request.getSession().getAttribute("user");
        if (username != null) {
            log.info("拦截到用户用户名为{}",username);
//            BaseContext.setCurrentId(employeeId);
            filterChain.doFilter(request, response);
            return;
        }

        String root = (String) request.getSession().getAttribute("root");
        if (root != null) {
            log.info("拦截到用户root为{}",root);
//            BaseContext.setCurrentId(userId);
            filterChain.doFilter(request, response);
            return;
        }

        log.info("用户未登录");
////        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
//        response.sendRedirect("/html/");
        response.sendRedirect("/html/common/login.html");
    }

    private boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            if (PATH_MATCHER.match(url, requestURI)) {
                return true;
            }
        }
        return false;
    }
}
