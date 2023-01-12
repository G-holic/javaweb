package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了LoginServlet的doGet方法....");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了LoginServlet的doPost方法....");
        final String username="admin";
        final String password="123456";
        String username1 = request.getParameter("username");
        String password1 = request.getParameter("password");
        if (username.equals(username1)&&password.equals(password1)){
            request.getRequestDispatcher("login_success.html").forward(request,response);
        }else request.getRequestDispatcher("login_error.html").forward(request,response);

    }
}
