package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class RequestTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得请求头的信息
        String header = request.getHeader("User-Agent");
        System.out.println("header = " + header);

        String referer = request.getHeader("Referer");
        System.out.println("referer = " + referer);

        // 获得url信息
        String contextPath = request.getContextPath(); // 获得上下文路径
        System.out.println("contextPath = " + contextPath);

        String serverName = request.getServerName();
        System.out.println("serverName = " + serverName);

        int serverPort = request.getServerPort();
        System.out.println("serverPort = " + serverPort);

        // 获得请求方式
        String method = request.getMethod();
        System.out.println("method = " + method);

        // 获得请求参数
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        String password = request.getParameter("password");
        System.out.println("password = " + password);

        String gender = request.getParameter("gender");
        System.out.println("gender = " + gender);

        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.print("hobby = " + hobby + "  ");// hobby = java  hobby = chang  hobby = tiao
        }

        System.out.println("--------------------");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> strings = parameterMap.keySet();// 获取所有的key值
        for (String string : strings) {
            System.out.println("key = " + string);
            String[] strings1 = parameterMap.get(string);
            for (String s : strings1) {
                System.out.print("s = " + s + " ");
            }
        }

        //跳转至root.html
        request.getRequestDispatcher("root.html").forward(request,response);

    }
}
