package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {
    protected void addCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.创建cookie对象并设置数据
        Cookie cookie01 = new Cookie("adminKey", "adminValue");
        Cookie cookie02 = new Cookie("rootKey", "rootValue");
        // 设置有效时间
        cookie01.setMaxAge(60);// 单位是秒
        cookie01.setPath(request.getContextPath()+"/user");
        // 设置cookie01只有在访问当前项目下的user下的请求时才会携带
        // 2.将cookie添加到响应报文内
        response.addCookie(cookie01);
        response.addCookie(cookie02);
        // 3.给响应
    }

    protected void aaa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("随意的请求，主要为了测试请求");
    }


    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
            }
        }
    }
}
