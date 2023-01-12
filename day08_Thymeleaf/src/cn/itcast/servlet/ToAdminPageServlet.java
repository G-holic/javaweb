package cn.itcast.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToAdminPageServlet extends ViewBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "这是请求域中的msg数据");
        ServletContext application = request.getServletContext();
        application.setAttribute("applicationMsg", "这是应用域中的msg数据");

        String id = request.getParameter("id");
        System.out.println("id = " + id);
        String name = request.getParameter("name");
        System.out.println("name = " + name);

        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

        String[] names = {"java", "mysql", "oracle"};
        request.setAttribute("names", names);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        request.setAttribute("list", list);


        this.processTemplate("admin", request, response);// 原理是转发
    }
}
