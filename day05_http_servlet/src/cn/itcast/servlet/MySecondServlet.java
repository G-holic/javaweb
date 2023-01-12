package cn.itcast.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MySecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问到了MySecondServlet的doGet方法....");
        ServletContext servletContext = req.getServletContext();
        System.out.println("servletContext = " + servletContext);

        // 作用域对象中获取共享数据
        Object msg = servletContext.getAttribute("msg");
        System.out.println("msg = " + msg);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问到了MySecondServlet的doPost方法....");
    }
}
