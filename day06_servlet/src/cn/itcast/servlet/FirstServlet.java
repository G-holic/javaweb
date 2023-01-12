package cn.itcast.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了FirstServlet.....");

        String id = request.getParameter("id");
        System.out.println("id = " + id);
        String name = request.getParameter("name");
        System.out.println("name = " + name);

        // 给SecondServlet共享数据
//        request.setAttribute("requestMsg","request共享的数据");

        // 通过转发，将请求转发到SecondServlet
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("second");
//        requestDispatcher.forward(request,response);

//        request.getRequestDispatcher("second").forward(request, response);

        // 转发到页面
//        request.getRequestDispatcher("admin.html").forward(request,response);
//        request.getRequestDispatcher("WEB-INF/root.html").forward(request,response);

        // 重定向到second
//        response.sendRedirect("/second");
        response.sendRedirect(request.getContextPath()+"/second");

        // 重定向到页面
//        response.sendRedirect("admin.html");
    }
}
