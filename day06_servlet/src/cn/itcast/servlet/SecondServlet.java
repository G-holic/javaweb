package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了SecondServlet...");
        String id = request.getParameter("id");
        System.out.println("id = " + id);
        String name = request.getParameter("name");
        System.out.println("name = " + name);

        // 获得共享数据
        /*Object requestMsg = request.getAttribute("requestMsg");
        System.out.println("requestMsg = " + requestMsg);*/

    }
}
