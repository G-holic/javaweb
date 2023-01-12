package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了ResponseTestServlet....");
        System.out.println("获取的请求参数、处理业务....");
        // 给响应 （通过转发进行页面的跳转）
        // 1. 将服务器的数据通过输出流的方式写给客户端
        response.addHeader("Content-Type","text/html;charset=utf-8");
        response.setContentType("text/html;charset=utf-8"); // 上面简写
        PrintWriter writer = response.getWriter();
        writer.write("<h1>success...</h1>");
        writer.write("success...");
        writer.write("success...");

    }
}
