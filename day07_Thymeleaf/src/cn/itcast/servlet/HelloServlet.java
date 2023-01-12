package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends ViewBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了HelloServlet...");
        System.out.println("此处应该调用业务层处理业务。。。。省略");
        // 已经拿到业务层的结果
        // 给响应(跳转至)
        String msg = "这是服务器的数据";
        // 去到Thymeleaf让Thymeleaf对页面做渲染操作
        request.setAttribute("msg", msg);
        this.processTemplate("admin", request, response);// 原理也是转发
    }
}
