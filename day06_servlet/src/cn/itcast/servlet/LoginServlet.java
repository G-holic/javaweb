package cn.itcast.servlet;

import cn.itcast.bean.User;
import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 1.获得请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        System.out.println("username = " + username);
        // 2.处理业务   // 3.给出响应（页面跳转）
        UserDaoImpl userDao = new UserDaoImpl();
        User userByUsername = userDao.findUserByUsername(username);
        if (userByUsername != null) {
            if (userByUsername.getPassword().equals(password)) {
                req.getRequestDispatcher("login_success.html").forward(req, resp);
            } else {
                // 密码错误
                req.getRequestDispatcher("login_error.html").forward(req, resp);
            }
        } else {
            // 用户名不正确
            req.getRequestDispatcher("login_error.html").forward(req, resp);
        }
    }
}

