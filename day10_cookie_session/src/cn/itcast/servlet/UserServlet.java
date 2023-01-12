package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends BaseServlet {
    protected void toLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = "";
        String password = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                }
                if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
            }
        }
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        this.processTemplate("login", request, response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        if (username.equals("admin") && password.equals("root")) {
            // 登录成功
            String confirm = request.getParameter("confirm");
            System.out.println("confirm = " + confirm);
            if (confirm != null) {
                // 将用户名和密码保存到cookie内
                Cookie usernameCookie = new Cookie("username", username);
                Cookie passwordCookie = new Cookie("password", password);

                usernameCookie.setMaxAge(60);

                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }
            writer.write("success");
        } else {
            // 登录失败
            writer.write("error");
        }
    }
}
